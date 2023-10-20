package com.bot.discord.my.discrod.command.create.hello;

import com.bot.discord.my.discrod.command.create.AbstractCommand;
import com.bot.discord.my.discrod.command.create.CommandDefinition;
import com.bot.discord.my.discrod.command.create.CommandResolver;
import com.bot.discord.my.discrod.command.create.CreateHandler;
import org.springframework.stereotype.Service;

@Service
public class HelloCommand extends AbstractCommand<HelloParams> {

    public HelloCommand(CommandDefinition<HelloParams> commandDefinition, CreateHandler<HelloParams> createHandler, CommandResolver<HelloParams> commandResolver) {
        super(commandDefinition, createHandler, commandResolver);
    }
}
