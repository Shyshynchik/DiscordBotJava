package com.bot.discord.my.discrod.commands.create.hello;

import com.bot.discord.my.discrod.commands.create.CreateHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HelloCommandCreateHandler implements CreateHandler<HelloParams> {

    private static final String message = "Hello %s!!!";

    @Override
    public Mono<Void> executeCommand(MessageCreateEvent event, HelloParams dto) {
        var eventMessage = event.getMessage();

        return Mono.just(eventMessage)
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(createMessage(dto)))
                .then();
    }

    private String createMessage(HelloParams dto) {
        return dto.getName() != null
                ? String.format(message, dto.getName())
                : String.format(message, "world");
    }
}
