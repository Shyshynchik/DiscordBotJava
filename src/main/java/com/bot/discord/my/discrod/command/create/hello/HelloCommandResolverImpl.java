package com.bot.discord.my.discrod.command.create.hello;

import com.bot.discord.my.discrod.command.create.CommandResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloCommandResolverImpl extends CommandResolver<HelloParams> {
    @Override
    protected HelloParams createParams() {
        return new HelloParams();
    }
}
