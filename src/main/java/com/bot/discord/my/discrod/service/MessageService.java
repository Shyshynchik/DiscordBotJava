package com.bot.discord.my.discrod.service;

import com.bot.discord.my.discrod.dto.MessageDto;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public interface MessageService {
    Mono<Message> sendMassage(Long channelId, MessageDto messageDto);
}
