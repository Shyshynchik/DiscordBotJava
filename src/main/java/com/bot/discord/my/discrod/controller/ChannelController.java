package com.bot.discord.my.discrod.controller;

import com.bot.discord.my.discrod.dto.ChannelDto;
import com.bot.discord.my.discrod.service.ChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@Tag(name = "Channels", description = "Api for channels")
@RequestMapping("/channels")
public class ChannelController {
    private final ChannelService channelService;
    @GetMapping("/all")
    @Operation(description = "Получает все текстовые каналы")
    public ResponseEntity<Flux<ChannelDto>> all() {
        var t = channelService.getAllTextChannels();
        return ResponseEntity.ok(t);
    }

}
