package com.bot.discord.my.discrod.utils;

import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.rest.util.PermissionSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(classes = AuthorizationUtilsImpl.class)
public class AuthorizationUtilsTest {

    @Autowired
    private AuthorizationUtils authorizationUtils;
    @Mock
    private Message message;
    @Mock
    private Member member;

    @BeforeEach
    public void init() {
        Mockito.when(message.getAuthorAsMember()).thenReturn(Mono.just(member));
    }

    @Test
    @DisplayName("Проверка, что пользователь без прав не является админом")
    public void test_for_admin_for_default_user() {
        //arrange
        Mockito.when(member.getBasePermissions()).thenReturn(Mono.just(PermissionSet.none()));
        //act
        var isAdmin = authorizationUtils.isAdmin(message);
        //assert
        Assertions.assertEquals(false, isAdmin.block());
    }

    @Test
    @DisplayName("Проверка, что пользователь со всеми правами является админом")
    public void test_for_admin_for_all_permissions() {
        //arrange
        Mockito.when(member.getBasePermissions()).thenReturn(Mono.just(PermissionSet.all()));
        //act
        var isAdmin = authorizationUtils.isAdmin(message);
        //assert
        Assertions.assertEquals(true, isAdmin.block());
    }

}
