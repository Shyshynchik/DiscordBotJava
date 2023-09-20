package com.bot.discord.my.discrod.commands.create.dog;

import com.bot.discord.my.discrod.api.dog.service.DogApi;
import com.bot.discord.my.discrod.commands.create.CreateHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DogCommandCreateHandler implements CreateHandler<DogParams> {

    private final DogApi dogApi;

    @Override
    public Mono<Void> executeCommand(MessageCreateEvent event, DogParams dogParams) {
        var eventMessage = event.getMessage();

        return Mono.just(eventMessage)
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(dogApi.getDogImage()))
                .then();
    }
}
