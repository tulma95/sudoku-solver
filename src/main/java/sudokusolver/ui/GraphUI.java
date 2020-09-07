package sudokusolver.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GraphUI extends Application {

    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                Button button = new Button(y + " j" + x);
                gridPane.add(button, y, x);
            }
        }

        Scene scene = new Scene(gridPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}