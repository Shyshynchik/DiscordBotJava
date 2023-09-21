package com.bot.discord.my.discrod.command.create.weather;

import lombok.Data;
import org.kohsuke.args4j.Argument;

@Data
public class WeatherParams {
    @Argument(usage = "Город, чью погоду необходимо узнать")
    private String city;
}
