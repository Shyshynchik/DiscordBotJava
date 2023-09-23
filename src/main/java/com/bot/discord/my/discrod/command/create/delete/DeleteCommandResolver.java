package com.bot.discord.my.discrod.command.create.delete;

import com.bot.discord.my.discrod.command.create.CommandResolver;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommandResolver implements CommandResolver<DeleteParams> {
    @Override
    public DeleteParams resolve(String commandLine) {
        if (commandLine.isBlank()) {
            return new DeleteParams();
        }
        var args = splitCommandLine(commandLine);

        var deleteParams = new DeleteParams();
        var parser = new CmdLineParser(deleteParams);

        try {
            parser.parseArgument(args);

            return deleteParams;
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
