package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Shape Test Suite ")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("test for circle")
    class TestCircle {
        @Test
        void testAddFigureCircle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("Circle", 1);
            //When
            shapeCollector.addFigure(circle);
            //Then
            assertTrue(shapeCollector.showFigures().contains("Circle"));
        }

        @Test
        void testRemoveFigureCircle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("Circle", 1);
            shapeCollector.addFigure(circle);
            //When
            boolean result = shapeCollector.removeFigure(circle);
            //Then
            assertTrue(result);
            assertFalse(shapeCollector.showFigures().contains("Circle"));
        }

        @Test
        void testGetFigureCircle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("Circle", 1);
            shapeCollector.addFigure(circle);
            //When
            Shape result = shapeCollector.getFigure(0);
            //Then
            assertEquals("Circle", result.getShapeName());
        }

    }

    @Nested
    @DisplayName("test for square")
    class TestSquare {
        @Test
        void testAddFigureSquare() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square("Square", 1);
            //When
            shapeCollector.addFigure(square);
            //Then
            assertTrue(shapeCollector.showFigures().contains("Square"));
        }

        @Test
        void testRemoveFigureSquare() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square("Square", 1);
            shapeCollector.addFigure(square);
            //When
            boolean result = shapeCollector.removeFigure(square);
            //Then
            assertTrue(result);
            assertFalse(shapeCollector.showFigures().contains("Square"));
        }

        @Test
        void testGetFigureSquare() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square("Square", 1);
            shapeCollector.addFigure(square);
            //When
            Shape result = shapeCollector.getFigure(0);
            //Then
            assertEquals("Square", result.getShapeName());
        }

    }

    @Nested
    @DisplayName("test for triangle")
    class TestTriangle {
        @Test
        void testAddFigureTriangle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle("Triangle", 1, 1);
            //When
            shapeCollector.addFigure(triangle);
            //Then
            assertTrue(shapeCollector.showFigures().contains("Triangle"));
        }

        @Test
        void testRemoveFigureTriangle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle("Triangle", 1, 1);
            shapeCollector.addFigure(triangle);
            //When
            boolean result = shapeCollector.removeFigure(triangle);
            //Then
            assertTrue(result);
            assertFalse(shapeCollector.showFigures().contains("Triangle"));
        }

        @Test
        void testGetFigureTriangle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle("Triangle", 1, 1);
            shapeCollector.addFigure(triangle);
            //When
            Shape result = shapeCollector.getFigure(0);
            //Then
            assertEquals("Triangle", result.getShapeName());
        }
    }

    @Nested
    @DisplayName("show names of all figures")
    class TestString {
        @Test
        void testString() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle("Triangle", 1, 1);
            Shape square = new Square("Square", 1);
            Shape circle = new Circle("Circle", 1);
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            //When
            String result = shapeCollector.showFigures();
            //Then
            assertEquals("Triangle,Square,Circle", result);
        }
    }

    @Nested
    @DisplayName("empty collections")
    class TestEmptyCollections {

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle("Triangle", 1, 1);
            //When
            boolean result = shapeCollector.removeFigure(triangle);
            //Then
            assertFalse(result);
        }

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle("Triangle", 1, 1);
            shapeCollector.addFigure(triangle);
            //When
            Shape result = shapeCollector.getFigure(1);
            //Then
            assertNull(result);
        }
    }
}

