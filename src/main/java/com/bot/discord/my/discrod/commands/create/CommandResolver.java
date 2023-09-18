package com.bot.discord.my.discrod.commands.create;

public interface CommandResolver<Dto> {

    Dto resolve(String commandLine);

    static String removeCommandName(String commandLine, String command) {
        return commandLine.substring(1).substring(command.length());
    }

    default String[] splitCommandLine(String commandLine) {
        return commandLine.trim().split(" ");
    }
}
