/**
 * Created by arun on 10/22/16.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GraphGUI extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane frame = new StackPane();
        Scene scene = new Scene(frame, 200, 50);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Testing");
        primaryStage.show();
    }
}
