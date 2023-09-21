package com.bot.discord.my.discrod.command.create;

public interface CommandResolver<T> {

    T resolve(String commandLine);

    static String removeCommandName(String commandLine, String command) {
        return commandLine.substring(1).substring(command.length());
    }

    default String[] splitCommandLine(String commandLine) {
        return commandLine.trim().split(" ");
    }
}
