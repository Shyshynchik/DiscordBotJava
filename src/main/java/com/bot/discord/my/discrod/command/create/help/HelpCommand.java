package com.bot.discord.my.discrod.command.create.help;

import com.bot.discord.my.discrod.command.create.Command;
import com.bot.discord.my.discrod.command.create.CommandDefinition;
import com.bot.discord.my.discrod.command.create.CommandResolver;
import com.bot.discord.my.discrod.command.create.CreateHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HelpCommand implements Command {

    private final CommandDefinition<HelpParams> commandDefinition;
    private final CreateHandler<HelpParams> createHandler;
    private final CommandResolver<HelpParams> commandResolver;

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
