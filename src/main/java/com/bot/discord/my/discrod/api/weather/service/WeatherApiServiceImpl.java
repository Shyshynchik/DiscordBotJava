package com.bot.discord.my.discrod.api.weather.service;

import com.bot.discord.my.discrod.api.weather.config.WeatherConfig;
import com.bot.discord.my.discrod.api.weather.model.CitiGeo;
import com.bot.discord.my.discrod.api.weather.model.Weather;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherApiServiceImpl implements WeatherApiService {

    private final WeatherConfig config;

    private final String geoUrl = "%s?q=%s&limit=%d&appid=%s";
    private final String weatherUrl = "%s?lat=%f&lon=%f&appid=%s&units=metric";

    @Override
    @SneakyThrows
    public List<CitiGeo> getCityGeoByCityName(String cityName) {
        WebClient client = WebClient.create();

        return client
                .get()
                .uri(new URI(String.format(geoUrl, config.getGeoUrl(), cityName, config.getLimit(), config.getToken())))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CitiGeo>>() {})
                .block();
    }

    @Override
    @SneakyThrows
    public Weather getWeatherByCity(String cityName) {

        var cityList = getCityGeoByCityName(cityName);

        if (cityList == null || cityList.isEmpty()) {
            return null;
        }
        WebClient client = WebClient.create();

        var city = cityList.get(0);

        return client
                .get()
                .uri(new URI(String.format(weatherUrl, config.getWeatherUrl(), city.getLat(), city.getLon(), config.getToken())))
                .retrieve()
                .bodyToMono(Weather.class)
                .block();
    }
}
