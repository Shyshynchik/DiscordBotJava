package com.bot.discord.my.discrod.api.weather.service;

import com.bot.discord.my.discrod.api.weather.client.WeatherApiClient;
import com.bot.discord.my.discrod.api.weather.model.Weather;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClient weatherApiClient;

    @Override
    @SneakyThrows
    public Mono<Weather> getWeatherByCity(String cityName) {
        return weatherApiClient.getWeatherByCity(cityName);
    }
}
