package com.bot.discord.my.discrod.command.create.weather;

import com.bot.discord.my.discrod.api.weather.service.WeatherService;
import com.bot.discord.my.discrod.api.weather.util.WeatherToStringConverter;
import com.bot.discord.my.discrod.command.create.CreateHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
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

        return Mono.just(eventMessage)
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(getWeatherMessage(dto)))
                .then();
    }

    private String getWeatherMessage(WeatherParams dto) {
        var weatherMono = weatherService.getWeatherByCity(dto.getCity());

        var weather = weatherMono
                .onErrorResume((er) -> Mono.empty())
                .block();

        if (weather == null) {
            return "Ничего не найдено";
        }

        return weatherToStringConverter.convertWeather(weather);
    }
}
