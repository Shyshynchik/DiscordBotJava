package com.bot.discord.my.discrod.api.weather.client;

import com.bot.discord.my.discrod.api.weather.model.Weather;
import reactor.core.publisher.Mono;

public interface WeatherApiClient {
    Mono<Weather> getWeatherByCity(String cityName);
}
