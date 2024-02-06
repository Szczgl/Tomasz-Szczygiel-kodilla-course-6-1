package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void login() {
        logger = Logger.LOGIN;
        logger.log("Tomasz");
    }

    @Test
    void testLogger() {
        //Given

        //Then
        String login = logger.getLastLog();

        //When
        assertEquals("Tomasz", login);
    }
}
