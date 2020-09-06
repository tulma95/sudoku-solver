package sudokusolver.domain.gamelogic;

import java.util.Arrays;

public class Sudoku {
    private int[][] gameboard;
    int size;

    public Sudoku(int[][] gameboard) {
        this.gameboard = gameboard;
        this.size = gameboard.length;
    }

    public int[][] getGameboard() {
        return gameboard;
    }

    public int getSize() {
        return size;
    }

    public boolean legalMove(int y, int x, int value) {

        for (int ys = 0; ys < size; ys++) {
            if (this.gameboard[ys][x] == value) return false;
        }
        for (int xs = 0; xs < size; xs++) {
            if (this.gameboard[y][xs] == value) return false;
        }
        return checkSmallSquare(y, x, value);
    }

    private boolean checkSmallSquare(int y, int x, int value) {
        int x0 = (x / 3) * 3;
        int y0 = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.gameboard[y0 + i][x0 + j] == value) return false;
            }
        }
        return true;
    }

    public void setNode(int y, int x, int value) {

        this.gameboard[y][x] = value;
    }

    public int getNode(int y, int x) {
        return this.gameboard[y][x];
    }

    public void printBoard() {
        Arrays.stream(gameboard)
                .forEach(e -> System.out.println(Arrays.toString(e)));
    }
}

