package com.bot.discord.my.discrod.api.weather.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class WeatherConfig {
    @Value("${spring.weather.token}")
    private String token;
    @Value("${spring.weather.default-weather-url}")
    private String weatherUrl;
}
