package com.bot.discord.my.discrod.listener;

import com.bot.discord.my.discrod.command.create.CommandResolver;
import com.bot.discord.my.discrod.command.create.CreateHandlerFactory;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CommandMessageCreateListener implements EventListener<MessageCreateEvent> {

    private final CreateHandlerFactory createHandlerFactory;

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        var messageContent = event.getMessage().getContent();
        if (!messageContent.startsWith("!") || event.getMessage().getAuthor().map(User::isBot).orElse(true)) {
            return Mono.empty();
        }

        var handler = createHandlerFactory.getCreateHandler(messageContent);

        return handler.map(h ->
                        h.execute(event, CommandResolver.removeCommandName(messageContent, h.getCommand())))
                .orElse(Mono.empty());
    }
}
