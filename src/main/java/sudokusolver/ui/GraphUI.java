package sudokusolver.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sudokusolver.domain.backtrackingalgorithm.Algorithm;
import sudokusolver.domain.gamelogic.Sudoku;

import static sudokusolver.domain.utils.ArrayUtils.deepEqual;

public class GraphUI extends Application {
    Sudoku sudoku;
    int[][] solution;
    Algorithm backtracking = new Algorithm();

    @Override
    public void start(Stage stage) {
        sudoku = new Sudoku(new int[][]{
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
        solution = backtracking.solve(sudoku).get(0);

        GridPane gridPane = new GridPane();

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                int[] yAndX = new int[]{y, x};

                Button button = new Button(sudoku.getNode(y, x) + "");

                button.setPrefSize(50, 50);
                button.setOnAction(e -> {
                    int currentValue = sudoku.getNode(yAndX[0], yAndX[1]);
                    int nextValue = currentValue == 9 ? 0 : ++currentValue;
                    sudoku.setNode(yAndX[0], yAndX[1], nextValue);
                    button.setText(nextValue + "");
                    if (deepEqual(sudoku.getGameboard(), solution)) {
                        System.out.println("VALMIS");
                    }
                });
                gridPane.add(button, x, y);
            }
        }


        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }

}