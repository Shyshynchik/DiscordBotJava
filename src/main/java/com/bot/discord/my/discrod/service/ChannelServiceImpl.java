package com.bot.discord.my.discrod.service;

import com.bot.discord.my.discrod.dto.ChannelDto;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.channel.TextChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final GatewayDiscordClient discordClient;
    @Override
    public Flux<ChannelDto> getAllTextChannels() {
        return discordClient.getGuilds()
                .flatMap(Guild::getChannels)
                .ofType(TextChannel.class)
                .map(this::buildChanelDto);
    }

    @Override
    public Mono<Boolean> isChannelExists(long channelID) {
        return discordClient.getGuilds()
                .flatMap(Guild::getChannels)
                .ofType(TextChannel.class)
                .filter(channel -> channel.getId().asLong() == channelID)
                .hasElements();
    }

    private ChannelDto buildChanelDto(TextChannel channel) {
        return ChannelDto.builder()
                .id(Long.toString(channel.getId().asLong()))
                .name(channel.getName())
                .build();
    }
}
