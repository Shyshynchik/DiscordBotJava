package com.bot.discord.my.discrod.command.create;

import discord4j.core.event.domain.message.MessageCreateEvent;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public abstract class AbstractCommand<T> implements Command {

    private final CommandDefinition<T> commandDefinition;
    private final CreateHandler<T> createHandler;
    private final CommandResolver<T> commandResolver;

    public String getCommand() {
        return commandDefinition.getCommand();
    }

    public boolean isActive() {
        return commandDefinition.isActive();
    }

    public Mono<Void> execute(MessageCreateEvent event, String commandLine) {
        var dto = commandResolver.resolve(commandLine);

        return createHandler.executeCommand(event, dto);
    }

}
