package com.bot.discord.my.discrod.command.create;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

public interface Command {
    String getCommand();
    boolean isActive();
    Mono<Void> execute(MessageCreateEvent event, String commandLine);
}
