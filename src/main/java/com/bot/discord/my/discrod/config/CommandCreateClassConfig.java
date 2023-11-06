package com.bot.discord.my.discrod.config;

import com.bot.discord.my.discrod.command.create.*;
import com.bot.discord.my.discrod.utils.ReflectionUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class CommandCreateClassConfig {
    @Bean
    public Map<Class<?>, CommandDefinition<?>> getMapCommandDefinitions(List<CommandDefinition<?>> commandDefinitions) {
        Map<Class<?>, CommandDefinition<?>> hashMap = new HashMap<>();
        commandDefinitions.forEach(commandDefinition -> {
            var commandClass = ReflectionUtils.getGenericParameterClassForInterface(commandDefinition.getClass());
            hashMap.put(commandClass, commandDefinition);
        });

        return hashMap;
    }

    @Bean
    public Map<Class<?>, CreateHandler<?>> getMapCreateHandlers(List<CreateHandler<?>> createHandlers) {
        Map<Class<?>, CreateHandler<?>> hashMap = new HashMap<>();
        createHandlers.forEach(createHandler -> {
            var commandClass = ReflectionUtils.getGenericParameterClassForInterface(createHandler.getClass());
            hashMap.put(commandClass, createHandler);
        });

        return hashMap;
    }

    @Bean
    public Map<Class<?>, CommandResolver<?>> getMapCommandResolvers(List<CommandResolver<?>> commandResolvers) {
        Map<Class<?>, CommandResolver<?>> hashMap = new HashMap<>();
        commandResolvers.forEach(commandResolver -> {
            var commandClass = ReflectionUtils.getGenericParameterClassForAbstract(commandResolver.getClass());
            hashMap.put(commandClass, commandResolver);
        });

        return hashMap;
    }

    @Bean
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Map<String, Command> getCommandsMap(Map<Class<?>, CommandDefinition<?>> commandDefinitionMap,
                                               Map<Class<?>, CreateHandler<?>> createHandlerMap,
                                               Map<Class<?>, CommandResolver<?>> commandResolverMap) {
        return commandDefinitionMap.keySet().stream()
                .filter(createHandlerMap::containsKey)
                .filter(commandResolverMap::containsKey)
                .filter(commandParam -> commandDefinitionMap.get(commandParam).isActive())
                .map(paramClass -> new ConcreteCommand(commandDefinitionMap.get(paramClass), createHandlerMap.get(paramClass), commandResolverMap.get(paramClass)))
                .collect(Collectors.toMap(ConcreteCommand::getCommand, command -> command));
    }
}
