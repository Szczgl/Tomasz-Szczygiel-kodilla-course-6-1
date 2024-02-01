package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    void testTaskAdd() {

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getDoneList().getTasks().add("Task done");
        board.getInProgressList().getTasks().add("Task in progress");
        board.getToDoList().getTasks().add("Task to do");

        //Then
        assertEquals("Task done", board.getDoneList().getTasks().get(0));
        assertEquals("Task in progress", board.getInProgressList().getTasks().get(0));
        assertEquals("Task to do", board.getToDoList().getTasks().get(0));
    }
}
