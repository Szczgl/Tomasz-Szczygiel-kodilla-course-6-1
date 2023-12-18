package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        Array array = new Array();
        int[] numbers = new int[20];

        for (int i = 0; i < 20; i++)
            numbers[i] = i;

        //When
        double resultAverage = array.getAverage(numbers);

        //Then
        assertEquals(9.5, resultAverage);
    }
}
