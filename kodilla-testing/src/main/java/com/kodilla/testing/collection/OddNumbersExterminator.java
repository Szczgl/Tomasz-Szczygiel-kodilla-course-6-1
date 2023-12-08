package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> collectionOfEvenNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                collectionOfEvenNumbers.add(number);
            }
        }
        return collectionOfEvenNumbers;
    }
}
