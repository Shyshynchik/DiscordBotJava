package com.bot.discord.my.discrod.command.create.delete;


import com.bot.discord.my.discrod.command.create.AbstractCommand;
import com.bot.discord.my.discrod.command.create.CommandDefinition;
import com.bot.discord.my.discrod.command.create.CommandResolver;
import com.bot.discord.my.discrod.command.create.CreateHandler;
import org.springframework.stereotype.Service;

@Service
public class DeleteCommand extends AbstractCommand<DeleteParams> {
    public DeleteCommand(CommandDefinition<DeleteParams> commandDefinition, CreateHandler<DeleteParams> createHandler, CommandResolver<DeleteParams> commandResolver) {
        super(commandDefinition, createHandler, commandResolver);
    }
}
