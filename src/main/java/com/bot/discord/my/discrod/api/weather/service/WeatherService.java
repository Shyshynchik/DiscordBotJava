package com.bot.discord.my.discrod.api.weather.service;

import com.bot.discord.my.discrod.api.weather.model.Weather;
import reactor.core.publisher.Mono;


public interface WeatherService {
    Mono<Weather> getWeatherByCity(String cityName);
}
