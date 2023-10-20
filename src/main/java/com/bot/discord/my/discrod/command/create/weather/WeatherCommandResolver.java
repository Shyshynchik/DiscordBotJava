package com.bot.discord.my.discrod.command.create.weather;

import com.bot.discord.my.discrod.command.create.CommandResolver;
import org.springframework.stereotype.Component;

@Component
public class WeatherCommandResolver extends CommandResolver<WeatherParams> {
    @Override
    protected WeatherParams createParams() {
        return new WeatherParams();
    }
}
