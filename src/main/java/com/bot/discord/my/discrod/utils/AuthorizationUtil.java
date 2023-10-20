package com.bot.discord.my.discrod.utils;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public interface AuthorizationUtil {

    Mono<Boolean> isAdmin(Message message);

}
