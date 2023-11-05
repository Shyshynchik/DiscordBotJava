package com.bot.discord.my.discrod.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChannelDto {
    String id;
    String name;
}
