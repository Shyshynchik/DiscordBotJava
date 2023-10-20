package com.bot.discord.my.discrod.command.create.delete;

import com.bot.discord.my.discrod.command.create.CommandResolver;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommandResolver extends CommandResolver<DeleteParams> {
    @Override
    protected DeleteParams createParams() {
        return new DeleteParams();
    }
}
