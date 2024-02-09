package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.task.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {

    @Test
    void testDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task driveTask = new DrivingTask("Jazda", "Kraków", "pociąg");

        //When
        Task drive = taskFactory.task(TaskFactory.DRIVING);
        driveTask.executeTask();


        //Then
        assertEquals("Jazda", drive.getTaskName());
        assertTrue(driveTask.isTaskExecuted());
    }

    @Test
    void testPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task paintTask = new PaintingTask("Malowanie", "czerwony", "samochód");

        //When
        Task paint = taskFactory.task(TaskFactory.PAINTING);
        paintTask.executeTask();

        //Then
        assertEquals("Malowanie", paint.getTaskName());
        assertTrue(paintTask.isTaskExecuted());
    }

    @Test
    void testShoppingTask() {
//Given
        TaskFactory taskFactory = new TaskFactory();
        Task shopTask = new ShoppingTask("Zakupy", "koszula", 2.0);

        //When
        Task shop = taskFactory.task(TaskFactory.SHOPPING);
        shopTask.executeTask();

        //Then
        assertEquals("Zakupy", shop.getTaskName());
        assertTrue(shopTask.isTaskExecuted());

    }
}
