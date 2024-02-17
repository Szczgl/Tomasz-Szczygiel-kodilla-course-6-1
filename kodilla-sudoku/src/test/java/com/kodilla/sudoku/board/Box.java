package com.kodilla.sudoku.board;

import java.util.*;

public class Box {

    public static final int SIZE = 9;
    public static final int EMPTY = 0;
    private int boxValue;
    private List<Integer> values;

    public Box() {
        this.boxValue = 0;
        this.values = new ArrayList<>();
        for (int i = 1; i <= SIZE; i++) {
            this.values.add(i);
        }
    }

    public int getBoxValue() {
        return boxValue;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setBoxValue(int boxValue) {
        this.boxValue = boxValue;
    }
}
