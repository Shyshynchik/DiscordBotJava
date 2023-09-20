package com.bot.discord.my.discrod.commands.create.weather;

import com.bot.discord.my.discrod.api.weather.service.WeatherApiService;
import com.bot.discord.my.discrod.commands.create.CreateHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class WeatherCommandCreateHandler implements CreateHandler<WeatherParams> {

    private final WeatherApiService weatherApiService;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final static String test1 = "Температура\uD83C\uDF21️ %.1f °С\nОщущается как\uD83E\uDD2F %.1f °С\nВосход\uD83C\uDF05 %s\nЗакат\uD83C\uDF07 %s";

    @Override
    public Mono<Void> executeCommand(MessageCreateEvent event, WeatherParams dto) {
        var eventMessage = event.getMessage();

        return Mono.just(eventMessage)
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(testApi1(dto)))
                .then();
    }

    private String testApi1(WeatherParams dto) {
        var response = weatherApiService.getWeatherByCity(dto.getCity());

        if (response == null) {
            return "Ничего не найдено";
        }

        var sunrise = Instant.ofEpochSecond(response.getSys().getSunrise()).atZone(ZoneId.systemDefault()).toLocalTime().format(formatter);
        var sunset = Instant.ofEpochSecond(response.getSys().getSunset()).atZone(ZoneId.systemDefault()).toLocalTime().format(formatter);

        return String.format(test1, response.getMain().getTemp(), response.getMain().getFeelsLike(), sunrise, sunset);
    }
}
