package com.kodilla.sudoku;

import com.kodilla.sudoku.board.Board;
import com.kodilla.sudoku.board.Box;

import java.util.Scanner;

public class SudokuGame {

    Scanner scanner = new Scanner(System.in);
    private Board board;

    public SudokuGame() {
        this.board = new Board();
    }

    public boolean game() {
        System.out.println(board.toString());

        System.out.println("Podaj ilość liczb, które chcesz wprowadzić (od 1 do 81):");
        int numbersToInput = scanner.nextInt();
        scanner.nextLine();

        if (numbersToInput < 1 || numbersToInput > 81) {
            System.out.println("Nieprawidłowa ilość liczb!");
            return false;
        }
    for (int i = 0; i < numbersToInput; i++) {
        System.out.println(" podaj współrzędne oraz liczbę którą chcesz wstawić np. 2,3,7");
        String input = scanner.nextLine();
        String[] parts = input.split(",");

        if (parts.length != 3) {
            System.out.println("Nieprawidłowy format danych!");
            return false;
        }

        int row = Integer.parseInt(parts[0].trim()) - 1;
        int col = Integer.parseInt(parts[1].trim()) - 1;
        int value = Integer.parseInt(parts[2].trim());

        if (row < 0 || row >= Box.SIZE || col < 0 || col >= Box.SIZE || value < 1 || value > 9) {
            System.out.println("Nieprawidłowe współrzędne lub wartość!");
            return false;
        }

        if (!isValidMove(row, col, value)) {
            System.out.println("Nieprawidłowy ruch! Spróbuj ponownie.");
            return false;
        }

        this.board.setBox(row, col, value);
        System.out.println("Wprowadzono wartość " + value + " do pola (" + (row + 1) + "," + (col + 1) + ")");
    }
        if (solve()) {
            System.out.println("Rozwiązanie Sudoku:");
            System.out.println(this.board);
        } else {
            System.out.println("Nieprawidłowe Sudoku!");
        }

        return true;
    }

    private boolean solve(int row, int col) {
        if (row == Box.SIZE) {
            row = 0;
            if (++col == Box.SIZE) {
                return true;
            }
        }
        if (this.board.getBoard().get(row).getRow().get(col).getBoxValue() != Box.EMPTY) {
            return solve(row + 1, col);
        }
        for (int value = 1; value <= Box.SIZE; ++value) {
            if (isValid(row, col, value)) {
                this.board.setBox(row, col, value);
                if (solve(row + 1, col)) {
                    return true;
                }
            }
        }
        this.board.setBox(row, col, Box.EMPTY);
        return false;
    }

    private boolean solve() {
        return solve(0,0);
    }

    private boolean isValidMove(int row, int col, int value) {
        for (int i = 0; i < Box.SIZE; i++) {
            if (this.board.getBoard().get(row).getRow().get(i).getBoxValue() == value) {
                return false;
            }
            if (this.board.getBoard().get(i).getRow().get(col).getBoxValue() == value) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (this.board.getBoard().get(i).getRow().get(j).getBoxValue() == value) {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean isValid(int row, int col, int value) {
        for (int i = 0; i < Box.SIZE; ++i) {
            if (this.board.getBoard().get(row).getRow().get(i).getBoxValue() == value ||
                    this.board.getBoard().get(i).getRow().get(col).getBoxValue() == value ||
                    this.board.getBoard().get(3 * (row / 3) + i / 3).getRow().get(3 * (col / 3) + i % 3).getBoxValue() == value) {
                return false;
            }
        }
        return true;
    }



public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameFinished = false;

        while (!gameFinished) {
            SudokuGame sudokuGame = new SudokuGame();
            sudokuGame.game();

            System.out.println("Chcesz grać jeszcze raz 't' ");
            String yesOrNot = scanner.nextLine();
            if (!yesOrNot.equals("t")) {
                gameFinished = true;
            }
        }

    }
}
