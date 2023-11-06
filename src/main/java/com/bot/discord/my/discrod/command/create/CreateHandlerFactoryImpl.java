package com.bot.discord.my.discrod.command.create;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreateHandlerFactoryImpl implements CreateHandlerFactory {
    private final Map<String, Command> commands;

    @Override
    public Optional<Command> getCreateHandler(String request) {
        var params = request.split(" ");

        var commandFromRequest = params[0].substring(1);

        var command = commands.get(commandFromRequest);

        if (command == null) {
            return Optional.empty();
        }

        return Optional.of(command);
    }

}
