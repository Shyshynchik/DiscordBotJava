package com.bot.discord.my.discrod.service;

import com.bot.discord.my.discrod.dto.MessageDto;
import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.TextChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final GatewayDiscordClient discordClient;
    private final ChannelService channelService;
    @Override
    public Mono<Message> sendMassage(Long channelId, MessageDto messageDto) {
        return channelService.isChannelExists(channelId)
                .flatMap(channelExists -> {
                    if (channelExists) {
                        return discordClient
                                .getChannelById(Snowflake.of(channelId))
                                .ofType(TextChannel.class)
                                .flatMap(channel -> channel.createMessage(messageDto.getMessage()));
                    } else {
                        return Mono.error(new RuntimeException("Channel with id " + channelId + " not found"));
                    }
                });
    }
}
