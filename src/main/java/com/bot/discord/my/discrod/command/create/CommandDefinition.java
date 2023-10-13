package com.bot.discord.my.discrod.command.create;

public interface CommandDefinition<T> {

    String getCommand();
    String getDescription();
    boolean isActive();
    Class<T> getDtoClass();
}
