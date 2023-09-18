package com.bot.discord.my.discrod.commands.create;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

public interface CreateHandler<Dto> {
    Mono<Void> executeCommand(MessageCreateEvent event, Dto dto);
}
