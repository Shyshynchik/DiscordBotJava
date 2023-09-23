package com.bot.discord.my.discrod.command.create.delete;

import com.bot.discord.my.discrod.command.create.CommandDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommandDefinition implements CommandDefinition<DeleteParams> {
    @Value("${spring.discord.create.delete.active}")
    private boolean isActive;

    @Override
    public String getCommand() {
        return "delete";
    }

    @Override
    public String getDescription() {
        return "Удаляет сообщения (10)";
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public Class<DeleteParams> getDtoClass() {
        return DeleteParams.class;
    }
}
