package com.bot.discord.my.discrod.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {
    @GetMapping("/")
    @Operation(hidden = true)
    public String Index() {
        return "Discord bot api <br> <a href='/api/swagger'>Swagger link</a>";
    }
}
