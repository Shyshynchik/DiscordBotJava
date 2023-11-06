package com.bot.discord.my.discrod.service;

import com.bot.discord.my.discrod.dto.ChannelDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChannelService {
    Flux<ChannelDto> getAllTextChannels();
    Mono<Boolean> isChannelExists(long channelID);
}
