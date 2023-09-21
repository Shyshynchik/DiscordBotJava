package com.bot.discord.my.discrod.command.create.help;

import com.bot.discord.my.discrod.command.create.CommandDefinition;
import org.springframework.stereotype.Component;

@Component
public class HelpCommandDefinition implements CommandDefinition<HelpParams> {
    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Выводит список активных комманд";
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public Class<HelpParams> getDtoClass() {
        return HelpParams.class;
    }
}
