package com.bot.discord.my.discrod.controller;

import com.bot.discord.my.discrod.dto.MessageDto;
import com.bot.discord.my.discrod.service.MessageService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Tag(name = "Messages", description = "Api for messages")
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;
    @PostMapping("/send/{channelId}")
    public Mono<ResponseEntity<Void>> sendMessage(
            @Parameter(description = "Id of text channel") @PathVariable Long channelId,
            @Parameter(description = "Message") @RequestBody MessageDto messageDto
            ) {
        return messageService
                .sendMassage(channelId, messageDto)
                .thenReturn(ResponseEntity.noContent().build());
    }

}
