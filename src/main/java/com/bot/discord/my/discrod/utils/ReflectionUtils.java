package com.bot.discord.my.discrod.utils;

import java.lang.reflect.ParameterizedType;

public class ReflectionUtils {
    public static Class<?> getGenericParameterClassForInterface(Class<?> actualClass) {
        return (Class<?>) ((ParameterizedType) actualClass.getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }
    public static Class<?> getGenericParameterClassForAbstract(Class<?> actualClass) {
        return (Class<?>) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
