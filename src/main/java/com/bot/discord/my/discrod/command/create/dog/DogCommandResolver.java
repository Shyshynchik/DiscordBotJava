package com.bot.discord.my.discrod.command.create.dog;

import com.bot.discord.my.discrod.command.create.CommandResolver;
import org.springframework.stereotype.Component;

@Component
public class DogCommandResolver extends CommandResolver<DogParams> {
    @Override
    protected DogParams createParams() {
        return new DogParams();
    }
}
