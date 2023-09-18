package com.bot.discord.my.discrod.commands.create;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreateHandlerFactoryImpl implements CreateHandlerFactory {
    private final List<Command> commands;

    public Optional<Command> getCreateHandler(String request) {
        var params = request.split(" ");

        var commandFromRequest = params[0].substring(1);

        for (var command: commands) {
            if (command.getCommand().equals(commandFromRequest) && command.isActive()) {
                return Optional.of(command);
            }
        }

        return Optional.empty();
    }

}
