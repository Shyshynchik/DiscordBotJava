package com.bot.discord.my.discrod.api.weather.util;

import com.bot.discord.my.discrod.api.weather.model.Weather;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherToStringConverterImpl implements WeatherToStringConverter {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final static String formatedString = "Температура\uD83C\uDF21️ %.1f °С\nОщущается как\uD83E\uDD2F %.1f °С\nВосход\uD83C\uDF05 %s\nЗакат\uD83C\uDF07 %s";

    @Override
    public String convertWeather(Weather weather) {
        var sunrise = Instant.ofEpochSecond(weather.getSys().getSunrise()).atZone(ZoneId.systemDefault()).toLocalTime().format(formatter);
        var sunset = Instant.ofEpochSecond(weather.getSys().getSunset()).atZone(ZoneId.systemDefault()).toLocalTime().format(formatter);

        return String.format(formatedString, weather.getMain().getTemp(), weather.getMain().getFeelsLike(), sunrise, sunset);
    }
}
