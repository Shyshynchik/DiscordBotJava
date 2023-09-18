package com.bot.discord.my.discrod.commands.create.hello;

import com.bot.discord.my.discrod.commands.create.Command;
import com.bot.discord.my.discrod.commands.create.CommandDefinition;
import com.bot.discord.my.discrod.commands.create.CommandResolver;
import com.bot.discord.my.discrod.commands.create.CreateHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HelloCommand implements Command {

    private final CommandDefinition<HelloParams> commandDefinition;
    private final CreateHandler<HelloParams> createHandler;
    private final CommandResolver<HelloParams> commandResolver;

    @Override
    public String getCommand() {
        return commandDefinition.getCommand();
    }

    @Override
    public boolean isActive() {
        return commandDefinition.isActive();
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event, String commandLine) {
        var dto = commandResolver.resolve(commandLine);

        return createHandler.executeCommand(event, dto);
    }
}
