package com.bot.discord.my.discrod.command.create.delete;

import com.bot.discord.my.discrod.command.create.CreateHandler;
import com.bot.discord.my.discrod.utils.AuthorizationUtil;
import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteCommandCreateHandler implements CreateHandler<DeleteParams> {
    private final AuthorizationUtil authorizationUtil;

    @Override
    public Mono<Void> executeCommand(MessageCreateEvent event, DeleteParams dto) {
        var eventMessage = event.getMessage();

        return Mono.just(eventMessage)
                .filterWhen(authorizationUtil::isAdmin)
                .flatMap(Message::getChannel)
                .flatMapMany(channel -> getMessageBefore(channel, eventMessage.getId()))
                .take(dto.getCount())
                .flatMap(Message::delete)
                .then(Mono.just(eventMessage))
                .filterWhen(authorizationUtil::isAdmin)
                .flatMap(message -> eventMessage.delete())
                .then(Mono.just(eventMessage))
                .filterWhen(authorizationUtil::isAdmin)
                .switchIfEmpty(Mono.defer(() -> eventMessage.getChannel()
                        .flatMap(channel -> channel.createMessage("У вас недостаточно прав"))))
                .then();


    }

    private Flux<Message> getMessageBefore(MessageChannel channel, Snowflake snowflake) {
        return channel.getMessagesBefore(snowflake);
    }
}
