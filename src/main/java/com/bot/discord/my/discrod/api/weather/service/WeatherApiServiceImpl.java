package com.bot.discord.my.discrod.api.weather.service;

import com.bot.discord.my.discrod.api.weather.config.WeatherConfig;
import com.bot.discord.my.discrod.api.weather.model.Weather;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class WeatherApiServiceImpl implements WeatherApiService {

    private final WeatherConfig config;
    private final String weatherUrl = "%s?q=%s&appid=%s&units=metric";

    @Override
    @SneakyThrows
    public Weather getWeatherByCity(String cityName) {

        WebClient client = WebClient.create();

        return client
                .get()
                .uri(new URI(String.format(weatherUrl, config.getWeatherUrl(), cityName, config.getToken())))
                .retrieve()
                .bodyToMono(Weather.class)
                .block();
    }
}
