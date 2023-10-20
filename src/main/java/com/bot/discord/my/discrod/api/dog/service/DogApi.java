package com.bot.discord.my.discrod.api.dog.service;

import reactor.core.publisher.Mono;

public interface DogApi {

    Mono<String> getDogImage();

}
