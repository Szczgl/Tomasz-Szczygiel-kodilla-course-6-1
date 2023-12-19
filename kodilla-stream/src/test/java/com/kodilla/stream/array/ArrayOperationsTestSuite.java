package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = new int[20];

        for (int i = 0; i < 20; i++)
            numbers[i] = i;

        //When
        double resultAverage = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(9.5, resultAverage);
    }
}
