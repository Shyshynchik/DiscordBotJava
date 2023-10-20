package com.bot.discord.my.discrod.command.create;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class CreateHandlerFactoryImpl implements CreateHandlerFactory {
    private final Map<String, Command> commands;

    public CreateHandlerFactoryImpl(List<Command> commands) {
        this.commands = new HashMap<>();

        commands.stream()
                .filter(Command::isActive)
                .forEach(command -> this.commands.put(command.getCommand(), command));
    }


    public Optional<Command> getCreateHandler(String request) {
        var params = request.split(" ");

        var commandFromRequest = params[0].substring(1);

        var command = commands.get(commandFromRequest);

        return Optional.of(command);
    }

}
