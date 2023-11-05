package com.bot.discord.my.discrod.service;

import com.bot.discord.my.discrod.dto.ChannelDto;
import reactor.core.publisher.Flux;

public interface ChannelService {
    Flux<ChannelDto> getAllTextChannels();
}
