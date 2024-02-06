package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Loger loger;

    @BeforeAll
    public static void login() {
        loger = Loger.LOGIN;
        loger.log("Tomasz");
    }

    @Test
    void testLogger() {
        //Given

        //Then
        String login = loger.getLastLog();

        //When
        assertEquals("Tomasz", login);
    }
}
