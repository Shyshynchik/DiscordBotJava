package com.bot.discord.my.discrod.utils;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.PartialMember;
import discord4j.rest.util.Permission;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationUtilsImpl implements AuthorizationUtils {
    @Override
    public Mono<Boolean> isAdmin(Message message) {
        return message.getAuthorAsMember()
                .flatMap(PartialMember::getBasePermissions)
                .map(permissions -> permissions.contains(Permission.MANAGE_MESSAGES));
    }
}
