package com.bot.discord.my.discrod.command.create.dog;

import com.bot.discord.my.discrod.command.create.CommandDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DogCommandDefinition implements CommandDefinition<DogParams> {

    @Value("${spring.discord.create.dog.active}")
    private boolean isActive;

    @Override
    public String getCommand() {
        return "собачка";
    }

    @Override
    public String getDescription() {
        return "Выводит изображение случайной собачки";
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public Class<DogParams> getDtoClass() {
        return DogParams.class;
    }
}
