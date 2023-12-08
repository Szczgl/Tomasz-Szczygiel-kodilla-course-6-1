package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin\n");
    }

    @AfterEach
    public void after() {
        System.out.println("\nTest Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin\n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("\nTest Suite: end");
    }

    @DisplayName("when the collection is empty")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> expectedResult = Collections.emptyList();
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(expectedResult);
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("when the collection contains even and odd")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> expectedResult = Arrays.asList(2);
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(Arrays.asList(1,2));
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}