package com.bot.discord.my.discrod.aspect;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Aspect
@Component
public class ExceptionHandlerAspect {

    @SuppressWarnings("unchecked")
    @Around(value = "execution(* com.bot.discord.my.discrod.command.create.Command.execute(..))")
    public Mono<Void> aroundCommandExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        var event = (MessageCreateEvent) joinPoint.getArgs()[0];
        try {
            return (Mono<Void>) joinPoint.proceed();
        } catch (Exception ex) {
            return Mono.just(event.getMessage())
                    .flatMap(Message::getChannel)
                    .flatMap(channel -> channel.createMessage(ex.getMessage()))
                    .then();
        }
    }

}
