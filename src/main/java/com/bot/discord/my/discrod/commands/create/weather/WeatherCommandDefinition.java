package com.bot.discord.my.discrod.commands.create.weather;

import com.bot.discord.my.discrod.commands.create.CommandDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherCommandDefinition implements CommandDefinition<WeatherParams> {

    @Value("${spring.discord.create.weather.active}")
    private boolean isActive;

    @Override
    public String getCommand() {
        return "weather";
    }

    @Override
    public String getDescription() {
        return "Выводит погоду для выбранного города";
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public Class<WeatherParams> getDtoClass() {
        return WeatherParams.class;
    }
}
