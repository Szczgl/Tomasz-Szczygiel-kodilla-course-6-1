package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)

@DisplayName("Mockito: Weather Forecast Test ")
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    void setUp() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 12.0);
        temperaturesMap.put("Krakow", 8.0);
        temperaturesMap.put("Wroclaw", 5.0);
        temperaturesMap.put("Warszawa", 14.0);
        temperaturesMap.put("Gdansk", 11.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);

    }

    @DisplayName("Test for calculate the forecast for several cities")
    @Test
    void testCalculateForecastWithMock() {
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @DisplayName("Test for calculating the average temperature")
    @Test
    void testCalculateAverageForecastWithMock() {

        //When
        Map<String, Double> avenargeTemperature = weatherForecast.calculateAverageForecast();

        //Then
        Assertions.assertEquals(10.0, avenargeTemperature.get("Avenarge temperature"));
    }

    @DisplayName("Calculating the average temperature for an odd number of cities")
    @Test
    void testCalculateMedianForecastOddNumberWithMock() {

        //When
        Map<String, Double> medianTemperature = weatherForecast.calculateMedianForecast();

        //Then
        Assertions.assertEquals(11.0, medianTemperature.get("Median temperature"));
    }

    @DisplayName("Calculating the average temperature for an even number of cities")
    @Test
    void testCalculateMedianForecastEvenNumberWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 12.0);
        temperaturesMap.put("Krakow", 8.0);
        temperaturesMap.put("Wroclaw", 5.0);
        temperaturesMap.put("Warszawa", 14.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        Map<String, Double> medianTemperature = weatherForecast.calculateMedianForecast();

        //Then
        Assertions.assertEquals(10.0, medianTemperature.get("Median temperature"));
    }
}