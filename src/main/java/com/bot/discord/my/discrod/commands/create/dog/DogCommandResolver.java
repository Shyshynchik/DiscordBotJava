package com.bot.discord.my.discrod.commands.create.dog;

import com.bot.discord.my.discrod.commands.create.CommandResolver;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.springframework.stereotype.Component;

@Component
public class DogCommandResolver implements CommandResolver<DogParams> {
    @Override
    public DogParams resolve(String commandLine) {
        if (commandLine.isBlank()) {
            return new DogParams();
        }
        var args = splitCommandLine(commandLine);

        var dogParamsCmd = new DogParams();
        var parser = new CmdLineParser(dogParamsCmd);

        try {
            parser.parseArgument(args);

            return dogParamsCmd;
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
