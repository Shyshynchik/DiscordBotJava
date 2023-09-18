package com.bot.discord.my.discrod.commands.create;

import java.util.Optional;

public interface CreateHandlerFactory {
     Optional<Command> getCreateHandler(String request);
}
