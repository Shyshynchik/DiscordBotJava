package com.bot.discord.my.discrod.command.create.weather;

import com.bot.discord.my.discrod.command.create.CommandDefinition;
import com.bot.discord.my.discrod.command.create.AbstractCommand;
import com.bot.discord.my.discrod.command.create.CommandResolver;
import com.bot.discord.my.discrod.command.create.CreateHandler;
import org.springframework.stereotype.Service;

@Service
public class WeatherCommand extends AbstractCommand<WeatherParams> {
    public WeatherCommand(CommandDefinition<WeatherParams> commandDefinition, CreateHandler<WeatherParams> createHandler, CommandResolver<WeatherParams> commandResolver) {
        super(commandDefinition, createHandler, commandResolver);
    }
}
