package com.bot.discord.my.discrod.command.create.delete;


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
public class DeleteCommand implements Command {

    private final CommandDefinition<DeleteParams> commandDefinition;
    private final CreateHandler<DeleteParams> createHandler;
    private final CommandResolver<DeleteParams> commandResolver;

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
        var delete = commandResolver.resolve(commandLine);

        return createHandler.executeCommand(event, delete);
    }
}
