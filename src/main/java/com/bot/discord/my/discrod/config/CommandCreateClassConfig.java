package com.bot.discord.my.discrod.config;

import com.bot.discord.my.discrod.command.create.*;
import com.bot.discord.my.discrod.command.create.delete.DeleteParams;
import com.bot.discord.my.discrod.command.create.dog.DogParams;
import com.bot.discord.my.discrod.command.create.hello.HelloParams;
import com.bot.discord.my.discrod.command.create.help.HelpParams;
import com.bot.discord.my.discrod.command.create.weather.WeatherParams;
import com.bot.discord.my.discrod.utils.ReflectionUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//    @Bean
//    @SuppressWarnings({"rawtypes", "unchecked"})
//    public List<Command> getCommands(Map<Class<?>, CommandDefinition<?>> commandDefinitionMap,
//                                     Map<Class<?>, CreateHandler<?>> createHandlerMap,
//                                     Map<Class<?>, CommandResolver<?>> commandResolverMap) {
//        return List.of(
//                new ConcreteCommand(commandDefinitionMap.get(DeleteParams.class), createHandlerMap.get(DeleteParams.class), commandResolverMap.get(DeleteParams.class)),
//                new ConcreteCommand(commandDefinitionMap.get(DogParams.class), createHandlerMap.get(DogParams.class), commandResolverMap.get(DogParams.class)),
//                new ConcreteCommand(commandDefinitionMap.get(HelloParams.class), createHandlerMap.get(HelloParams.class), commandResolverMap.get(HelloParams.class)),
//                new ConcreteCommand(commandDefinitionMap.get(HelpParams.class), createHandlerMap.get(HelpParams.class), commandResolverMap.get(HelpParams.class)),
//                new ConcreteCommand(commandDefinitionMap.get(WeatherParams.class), createHandlerMap.get(WeatherParams.class), commandResolverMap.get(WeatherParams.class))
//        );
//    }

    @Bean
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Map<String, Command> getCommandsMap(Map<Class<?>, CommandDefinition<?>> commandDefinitionMap,
                                               Map<Class<?>, CreateHandler<?>> createHandlerMap,
                                               Map<Class<?>, CommandResolver<?>> commandResolverMap) {


        return Stream.of(
                        new ConcreteCommand(commandDefinitionMap.get(DeleteParams.class), createHandlerMap.get(DeleteParams.class), commandResolverMap.get(DeleteParams.class)),
                        new ConcreteCommand(commandDefinitionMap.get(DogParams.class), createHandlerMap.get(DogParams.class), commandResolverMap.get(DogParams.class)),
                        new ConcreteCommand(commandDefinitionMap.get(HelloParams.class), createHandlerMap.get(HelloParams.class), commandResolverMap.get(HelloParams.class)),
                        new ConcreteCommand(commandDefinitionMap.get(HelpParams.class), createHandlerMap.get(HelpParams.class), commandResolverMap.get(HelpParams.class)),
                        new ConcreteCommand(commandDefinitionMap.get(WeatherParams.class), createHandlerMap.get(WeatherParams.class), commandResolverMap.get(WeatherParams.class))
                )
                .collect(Collectors.toMap(ConcreteCommand::getCommand, command -> command));

    }
}
