package com.bot.discord.my.discrod.api.weather.util;

import com.bot.discord.my.discrod.api.weather.model.Weather;

public interface WeatherToStringConverter {
    String convertWeather(Weather weather);
}
