package com.bot.discord.my.discrod.command.create.help;

import com.bot.discord.my.discrod.command.create.CommandResolver;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.springframework.stereotype.Component;

@Component
public class HelpCommandResolver implements CommandResolver<HelpParams> {
    @Override
    public HelpParams resolve(String commandLine) {
        if (commandLine.isBlank()) {
            return new HelpParams();
        }
        var args = splitCommandLine(commandLine);

        var helloParams = new HelpParams();
        var parser = new CmdLineParser(helloParams);

        try {
            parser.parseArgument(args);

            return helloParams;
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
