package com.bot.discord.my.discrod.api.weather.service;

import com.bot.discord.my.discrod.api.weather.model.CitiGeo;
import com.bot.discord.my.discrod.api.weather.model.Weather;

import java.util.List;

public interface WeatherApiService {
    List<CitiGeo> getCityGeoByCityName(String cityName);
    Weather getWeatherByCity(String cityName);
}
