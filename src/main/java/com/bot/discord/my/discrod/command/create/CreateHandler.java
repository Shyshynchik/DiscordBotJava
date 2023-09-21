package com.bot.discord.my.discrod.command.create;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

public interface CreateHandler<T> {
    Mono<Void> executeCommand(MessageCreateEvent event, T dto);
}
