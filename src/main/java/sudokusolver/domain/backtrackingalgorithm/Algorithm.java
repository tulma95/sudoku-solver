package sudokusolver.domain.backtrackingalgorithm;

import sudokusolver.domain.gamelogic.Sudoku;
import sudokusolver.domain.utils.ArrayList;

import static sudokusolver.domain.utils.ArrayUtils.copy;

public class Algorithm {
    private Sudoku sudoku;
    private ArrayList<int[][]> solutions;

    public ArrayList<int[][]> solve(Sudoku sudoku) {
        solutions = new ArrayList<>();
        this.sudoku = sudoku;
        backTrackingAlgorithm();
        return solutions;
    }

    private void backTrackingAlgorithm() {
        for (int y = 0; y < sudoku.getSize(); y++) {
            for (int x = 0; x < sudoku.getSize(); x++) {
                if (sudoku.getNode(y, x) == 0) {
                    for (int i = 1; i < 10; i++) {
                        if (sudoku.legalMove(y, x, i)) {
                            sudoku.setNode(y, x, i);
                            backTrackingAlgorithm();
                            sudoku.setNode(y, x, 0);
                        }
                    }
                    return;
                }
            }
        }
        solutions.add(copy(sudoku.getGameboard()));
    }
}
