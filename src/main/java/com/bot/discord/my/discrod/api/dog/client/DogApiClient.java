package com.bot.discord.my.discrod.api.dog.client;

import com.bot.discord.my.discrod.api.dog.model.DogImage;
import reactor.core.publisher.Mono;

public interface DogApiClient {
    Mono<DogImage> getDogImage();
}
