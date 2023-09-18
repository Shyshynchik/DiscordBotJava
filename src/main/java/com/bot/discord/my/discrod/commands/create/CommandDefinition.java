package com.bot.discord.my.discrod.commands.create;

public interface CommandDefinition<Dto> {

    String getCommand();
    String getDescription();
    boolean isActive();

    Class<Dto> getDtoClass();
}
