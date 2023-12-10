package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Map<String, Double> calculateAverageForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        double sum = 0;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            double temperatueList = temperature.getValue();
            sum += temperatueList;
        }

        resultMap.put("Avenarge temperature", sum/temperatures.getTemperatures().size());
        return resultMap;
    }

    public Map<String, Double> calculateMedianForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        List<Double> temperatureValue = new ArrayList<>();
        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            temperatureValue.add(temperature.getValue());
        }
        Collections.sort(temperatureValue);
        int sizeArrayList = temperatureValue.size();
        if (sizeArrayList % 2 == 0) {
            int middleIndexOne = (sizeArrayList-2)/2;
            int middleIndexTwo = sizeArrayList/2;
            Double middleIndexValue = (temperatureValue.get(middleIndexOne)+temperatureValue.get(middleIndexTwo))/2;

            resultMap.put("Median temperature", middleIndexValue);
        } else {
            int middleIndex = (sizeArrayList-1)/2;
            resultMap.put("Median temperature", temperatureValue.get(middleIndex));
        }
        return resultMap;
    }
}
