package com.bot.discord.my.discrod.api.dog.service;

import com.bot.discord.my.discrod.api.dog.client.DogApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DogApiImpl implements DogApi {
    private final DogApiClient dogApiClient;

    @Override
    public Mono<String> getDogImage() {
        var dogImage = dogApiClient.getDogImage();

        return dogImage.map(response ->
                response != null
                        ? response.getMessage()
                        : "Not found");
    }
}
