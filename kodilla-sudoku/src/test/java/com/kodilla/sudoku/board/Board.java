package com.kodilla.sudoku.board;

import java.util.*;

public class Board {

    private List<Row> board;
    public Board() {
        this.board = new ArrayList<>();
        for (int i = 0; i < Box.SIZE; i++) {
            this.board.add(new Row());
        }
    }

    public List<Row> getBoard() {
        return board;
    }

    public void setBox(int row, int col, int value) {
        this.board.get(row).getRow().get(col).setBoxValue(value);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Box.SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                stringBuilder.append("- - - - - - - - - - -\n");
            }
            for (int j = 0; j < Box.SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    stringBuilder.append("| ");
                }
                int value = this.board.get(i).getRow().get(j).getBoxValue();
                stringBuilder.append(value == 0 ? " " : value).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
