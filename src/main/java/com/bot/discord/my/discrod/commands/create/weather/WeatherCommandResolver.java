package com.bot.discord.my.discrod.commands.create.weather;

import com.bot.discord.my.discrod.commands.create.CommandResolver;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.springframework.stereotype.Component;

@Component
public class WeatherCommandResolver implements CommandResolver<WeatherParams> {
    @Override
    public WeatherParams resolve(String commandLine) {
        if (commandLine.isBlank()) {
            return new WeatherParams();
        }
        var args = splitCommandLine(commandLine);

        var weatherParams = new WeatherParams();
        var parser = new CmdLineParser(weatherParams);

        try {
            parser.parseArgument(args);

            return weatherParams;
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
