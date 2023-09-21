package com.bot.discord.my.discrod.command.create.delete;

import lombok.Data;
import org.kohsuke.args4j.Argument;

@Data
public class DeleteParams {
    @Argument(usage = "Город, чью погоду необходимо узнать")
    private Integer count = 10;
}
