package com.bot.discord.my.discrod.commands.create.help;

import com.bot.discord.my.discrod.commands.create.CommandDefinition;
import com.bot.discord.my.discrod.commands.create.CreateHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import lombok.RequiredArgsConstructor;
import org.kohsuke.args4j.Option;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HelpCommandCreateHandler implements CreateHandler<HelpParams> {
    private final List<CommandDefinition<?>> commands;
    private static final String pattern = "!%s - %s\n";
    @Override
    public Mono<Void> executeCommand(MessageCreateEvent event, HelpParams helpParams) {
        var eventMessage = event.getMessage();

        return Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(prepareMessage()))
                .then();
    }

    private String prepareMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        for (var command : commands) {
            if (!command.isActive()) {
                continue;
            }
            //TODO в отдельный метод
            var flagBuilder = new StringBuilder();
            for (var flag : command.getDtoClass().getDeclaredFields()) {
                if (!flag.isAnnotationPresent(Option.class)) {
                    continue;
                }
                var flagAnnotation = flag.getAnnotation(Option.class);
                flagBuilder.append("\t");
                flagBuilder.append(flagAnnotation.name());
                flagBuilder.append("\t");
                for (var alias: flagAnnotation.aliases()) {
                    flagBuilder.append(alias);
                    flagBuilder.append("\t");
                }
                flagBuilder.append("\t");
                flagBuilder.append(flag.getAnnotation(Option.class).usage());
                flagBuilder.append("\n");
            }
            stringBuilder.append(String.format(pattern, command.getCommand(), command.getDescription()));
            stringBuilder.append(flagBuilder);
        }

        return stringBuilder.toString();
    }
}
