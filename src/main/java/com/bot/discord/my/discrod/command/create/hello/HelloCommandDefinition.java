package com.bot.discord.my.discrod.command.create.hello;

import com.bot.discord.my.discrod.command.create.CommandDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloCommandDefinition implements CommandDefinition<HelloParams> {

    @Value("${spring.discord.create.hello.active}")
    private boolean isActive;

    @Override
    public String getCommand() {
        return "hello";
    }

    @Override
    public String getDescription() {
        return "Привет мир!";
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public Class<HelloParams> getDtoClass() {
        return HelloParams.class;
    }
}
