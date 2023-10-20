package com.bot.discord.my.discrod.command.create.help;

import com.bot.discord.my.discrod.command.create.AbstractCommand;
import com.bot.discord.my.discrod.command.create.CommandDefinition;
import com.bot.discord.my.discrod.command.create.CommandResolver;
import com.bot.discord.my.discrod.command.create.CreateHandler;
import org.springframework.stereotype.Service;

@Service
public class HelpCommand extends AbstractCommand<HelpParams> {
    public HelpCommand(CommandDefinition<HelpParams> commandDefinition, CreateHandler<HelpParams> createHandler, CommandResolver<HelpParams> commandResolver) {
        super(commandDefinition, createHandler, commandResolver);
    }
}
