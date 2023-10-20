package com.bot.discord.my.discrod.command.create.weather;

import com.bot.discord.my.discrod.api.weather.model.Weather;
import com.bot.discord.my.discrod.api.weather.service.WeatherService;
import com.bot.discord.my.discrod.api.weather.util.WeatherToStringConverter;
import com.bot.discord.my.discrod.command.create.CreateHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WeatherCommandCreateHandler implements CreateHandler<WeatherParams> {

    private final WeatherService weatherService;
    private final WeatherToStringConverter weatherToStringConverter;


    @Override
    public Mono<Void> executeCommand(MessageCreateEvent event, WeatherParams dto) {
        var eventMessage = event.getMessage();

        return getWeatherMessageMono(dto)
                .flatMap(weatherMessage -> eventMessage.getChannel()
                        .flatMap(
                                channel -> channel.createMessage(weatherMessage)
                        )
                )
                .then();
    }

    private Mono<String> getWeatherMessageMono(WeatherParams dto) {
        return Mono.just(dto)
                .flatMap(weatherParams -> weatherService.getWeatherByCity(weatherParams.getCity()))
                .onErrorResume((er) -> Mono.empty())
                .map(this::getWeatherMessage);
    }

    private String getWeatherMessage(Weather weather) {
        if (weather == null) {
            return "Ничего не найдено";
        }

        return weatherToStringConverter.convertWeather(weather);
    }
}
