package com.bot.discord.my.discrod.command.create;

import com.bot.discord.my.discrod.command.create.weather.WeatherParams;
import org.springframework.stereotype.Service;

@Service
public class WeatherCommandI extends CommandMain<WeatherParams> {
    public WeatherCommandI(CommandDefinition<WeatherParams> commandDefinition, CreateHandler<WeatherParams> createHandler, CommandResolver<WeatherParams> commandResolver) {
        super(commandDefinition, createHandler, commandResolver);
    }
}
