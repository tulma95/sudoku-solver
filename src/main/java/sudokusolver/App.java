package sudokusolver;

import sudokusolver.domain.backtrackingalgorithm.Algorithm;
import sudokusolver.domain.gamelogic.Sudoku;
import sudokusolver.ui.GraphUI;


public class App {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        });

        Algorithm backtracking = new Algorithm();
        backtracking.solve(sudoku);
        GraphUI.main(args);

    }


}