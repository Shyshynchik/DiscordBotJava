package com.bot.discord.my.discrod.api.dog.service;

import com.bot.discord.my.discrod.api.dog.client.DogApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogApiImpl implements DogApi {
    private final DogApiClient dogApiClient;
    @Override
    public String getDogImage() {
        var dogImage = dogApiClient.getDogImage();

        return dogImage != null
                ? dogImage.getMessage()
                : "Not found";
    }
}
