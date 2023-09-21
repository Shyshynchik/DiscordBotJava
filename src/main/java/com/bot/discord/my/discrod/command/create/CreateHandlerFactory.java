package com.bot.discord.my.discrod.command.create;

import java.util.Optional;

public interface CreateHandlerFactory {
     Optional<Command> getCreateHandler(String request);
}
