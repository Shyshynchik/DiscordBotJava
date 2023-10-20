package com.bot.discord.my.discrod.command.create.dog;


import com.bot.discord.my.discrod.command.create.*;
import org.springframework.stereotype.Service;

@Service
public class DogCommand extends AbstractCommand<DogParams> {
    public DogCommand(CommandDefinition<DogParams> commandDefinition, CreateHandler<DogParams> createHandler, CommandResolver<DogParams> commandResolver) {
        super(commandDefinition, createHandler, commandResolver);
    }
}
