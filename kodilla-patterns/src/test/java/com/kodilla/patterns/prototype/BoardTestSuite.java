package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTestSuite {

    @Test
    void testToString() {

        //Given
        TaskList listToDo = new TaskList("To Do Task");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

        TaskList listInProgress = new TaskList("In Progress Task ");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task " + n)));

        TaskList listDone = new TaskList("Done Task ");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));

        Board board = new Board("Project nr 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        Board cloneBoard = null;
        try {
            cloneBoard = board.shallowCopy();
            cloneBoard.setName("Project nr 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Board deepCloneBoard = null;
        try {
            deepCloneBoard = board.deepCopy();
            cloneBoard.setName("Project nr 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(board);
        System.out.println(cloneBoard);
        System.out.println(deepCloneBoard);

        //When
        board.getLists().remove(listToDo);

        //Then
        assertEquals(2, board.getLists().size());
        assertEquals(2, cloneBoard.getLists().size());
        assertEquals(3, deepCloneBoard.getLists().size());
        assertEquals(cloneBoard.getLists(), board.getLists());
        assertNotEquals(deepCloneBoard.getLists(), board.getLists());

    }
}
