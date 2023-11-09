package com.bot.discord.my.discrod.utils;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public interface AuthorizationUtils {

    Mono<Boolean> isAdmin(Message message);

}
