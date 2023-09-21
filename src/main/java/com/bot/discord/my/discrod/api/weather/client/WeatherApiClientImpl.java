package com.bot.discord.my.discrod.api.weather.client;

import com.bot.discord.my.discrod.api.weather.config.WeatherConfig;
import com.bot.discord.my.discrod.api.weather.model.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@RequiredArgsConstructor
public class WeatherApiClientImpl implements WeatherApiClient {
    private final String weatherUrl = "%s?q=%s&appid=%s&units=metric&lang=ru";
    private final WeatherConfig config;

    @Override
    public Mono<Weather> getWeatherByCity(String cityName) {
        WebClient client = WebClient.create();

        try {
            return client
                    .get()
                    .uri(new URI(String.format(weatherUrl, config.getWeatherUrl(), cityName, config.getToken())))
                    .retrieve()
                    .bodyToMono(Weather.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getReason());
        }
    }
}
