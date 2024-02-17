package com.kodilla.sudoku.board;

import java.util.*;

public class Row {

    private List<Box> row;

    public Row() {
        this.row = new ArrayList<>();
        for (int i = 0; i < Box.SIZE; i++) {
            this.row.add(new Box());
        }
    }

    public List<Box> getRow() {
        return row;
    }
}
