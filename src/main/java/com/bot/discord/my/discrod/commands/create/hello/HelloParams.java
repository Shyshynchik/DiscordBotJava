package com.bot.discord.my.discrod.commands.create.hello;

import lombok.Data;
import org.kohsuke.args4j.Option;

@Data
public class HelloParams {

    @Option(name = "-n", aliases = "--name",
            usage = "Имя, которое будет выведено в формате Hello {name}!!!")
    private String name;

}
