package com.bot.discord.my.discrod.api.dog.client;

import com.bot.discord.my.discrod.api.dog.model.DogImage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class DogApiClientImpl implements DogApiClient {
    @Override
    public Mono<DogImage> getDogImage() {
        WebClient client = WebClient.create();

        try {
            return client
                    .get()
                    .uri(new URI("https://dog.ceo/api/breeds/image/random"))
                    .retrieve()
                    .bodyToMono(DogImage.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
