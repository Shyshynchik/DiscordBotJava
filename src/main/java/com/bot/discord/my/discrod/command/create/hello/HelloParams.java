package com.bot.discord.my.discrod.command.create.hello;

import lombok.Data;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.StringArrayOptionHandler;

import java.util.List;

@Data
public class HelloParams {

    @Option(name = "-n", aliases = "--name",
            usage = "Имя, которое будет выведено в формате Hello {name}!!!", handler = StringArrayOptionHandler.class)
    private List<String> name;

}
