package com.bot.discord.my.discrod.command.create;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public abstract class CommandResolver<T> {

    public T resolve(String commandLine) {
        if (commandLine.isBlank()) {
            return createParams();
        }
        var args = splitCommandLine(commandLine);

        T dogParamsCmd = createParams();
        var parser = new CmdLineParser(dogParamsCmd);

        try {
            parser.parseArgument(args);

            return dogParamsCmd;
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    protected abstract T createParams();

    public static String removeCommandName(String commandLine, String command) {
        return commandLine.substring(1).substring(command.length());
    }

    protected String[] splitCommandLine(String commandLine) {
        return commandLine.trim().split(" ");
    }
}
