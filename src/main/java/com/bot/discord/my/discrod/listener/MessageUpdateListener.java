package com.bot.discord.my.discrod.listener;

import discord4j.core.event.domain.message.MessageUpdateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MessageUpdateListener implements EventListener<MessageUpdateEvent> {

    @Override
    public Class<MessageUpdateEvent> getEventType() {
        return MessageUpdateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageUpdateEvent event) {
        return Mono.just(event)
                .filter(MessageUpdateEvent::isContentChanged)
                .flatMap(messageUpdateEvent -> messageUpdateEvent.getOld().map(this::handleUpdateMessage).orElseGet(Mono::empty))
                .then();
    }


    private Mono<Void> handleUpdateMessage(Message message) {
        var text = "Сообщение было изменено, оригинальное сообщение: \n" + message.getContent();

        return Mono.just(message)
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(text))
                .then();
    }
}
