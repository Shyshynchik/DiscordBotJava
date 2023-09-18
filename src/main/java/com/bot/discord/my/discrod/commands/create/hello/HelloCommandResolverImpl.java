package com.bot.discord.my.discrod.commands.create.hello;

import com.bot.discord.my.discrod.commands.create.CommandResolver;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.springframework.stereotype.Component;

@Component
public class HelloCommandResolverImpl implements CommandResolver<HelloParams> {
    @Override
    public HelloParams resolve(String commandLine) {
        if (commandLine.isBlank()) {
            return new HelloParams();
        }
        var args = splitCommandLine(commandLine);

        var helloParams = new HelloParams();
        var parser = new CmdLineParser(helloParams);

        try {
            parser.parseArgument(args);

            return helloParams;
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
