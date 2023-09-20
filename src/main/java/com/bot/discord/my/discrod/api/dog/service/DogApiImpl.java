package com.bot.discord.my.discrod.api.dog.service;

import com.bot.discord.my.discrod.api.dog.model.DogImage;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Component
public class DogApiImpl implements DogApi {
    @Override
    @SneakyThrows

    public String getDogImage() {
        WebClient client = WebClient.create();

        var response = client
                .get()
                .uri(new URI("https://dog.ceo/api/breeds/image/random"))
                .retrieve()
                .bodyToMono(DogImage.class)
                .block();

        if (response != null) {
            return response.getMessage();
        }

        return "Not found";
    }
}
