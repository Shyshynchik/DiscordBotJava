package com.bot.discord.my.discrod.command.create.help;

import com.bot.discord.my.discrod.command.create.CommandResolver;
import org.springframework.stereotype.Component;

@Component
public class HelpCommandResolver extends CommandResolver<HelpParams> {
    @Override
    protected HelpParams createParams() {
        return new HelpParams();
    }
}
