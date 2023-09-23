package com.bot.discord.my.discrod.command.create.delete;

import com.bot.discord.my.discrod.command.create.CreateHandler;
import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.PartialMember;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.rest.util.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteCommandCreateHandler implements CreateHandler<DeleteParams> {
    @Override
    public Mono<Void> executeCommand(MessageCreateEvent event, DeleteParams dto) {
        var eventMessage = event.getMessage();

        return Mono.just(eventMessage)
                .filterWhen(this::isAdmin)
                .flatMap(Message::getChannel)
                .flatMapMany(channel -> getMessageBefore(channel, eventMessage.getId()))
                .take(dto.getCount())
                .flatMap(Message::delete)
                .then(Mono.just(eventMessage))
                .flatMap(message -> eventMessage.delete())
                .then();
    }

    private Mono<Boolean> isAdmin(Message message) {
        return message.getAuthorAsMember()
                .flatMap(PartialMember::getBasePermissions)
                .map(permissions -> permissions.contains(Permission.MANAGE_MESSAGES));
    }

    private Flux<Message> getMessageBefore(MessageChannel channel, Snowflake snowflake) {
        return channel.getMessagesBefore(snowflake);
    }
}
