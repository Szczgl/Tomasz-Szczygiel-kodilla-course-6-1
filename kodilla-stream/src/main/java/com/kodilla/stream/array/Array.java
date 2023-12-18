package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Array implements ArrayOperations {

    public double getAverage(int[] numbers){

        String dispalyResult = IntStream.range(0,numbers.length)
                .mapToObj(i -> "number[" + i + "] = " + numbers[i])
                .collect(Collectors.joining("\n"));
        System.out.println(dispalyResult);

        double averageResult = IntStream.range(0,numbers.length)
                .mapToDouble(i -> numbers[i])
                .average().getAsDouble();
        return averageResult;
    }
}
