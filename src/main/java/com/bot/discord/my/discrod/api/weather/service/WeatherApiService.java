package com.bot.discord.my.discrod.api.weather.service;

import com.bot.discord.my.discrod.api.weather.model.Weather;


public interface WeatherApiService {
    Weather getWeatherByCity(String cityName);
}
