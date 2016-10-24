/**
 * This class deals with all of the GUI for the project. This is also has the main method to run
 * the program.
 *
 * @author Arun Arjunakani
 * @version 2016, October 24
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class GraphGUI extends Application
{
    /**
     * This is the main method which runs the entire program.
     * @param args
     * @return Nothing.
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * This is the method that sets up all of the GUI. This is required in all classes that implement
     * the JavaFX Application class.
     * @param primaryStage
     * @return Nothing.
     */
    @Override
    public void start(Stage primaryStage)
    {
        TilePane main = new TilePane();

        Scene scene = new Scene(main, 1000, 700);
        VBox buttons = new VBox(8);
        Button btn = new Button("Hello");
        buttons.getChildren().add(btn);
        btn.setOnAction(event -> {
            if(primaryStage.getScene() == scene)
            {
                System.out.println("We must switch!");
            }
        });

        main.getChildren().add(buttons);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Arloper's Algorithm");
        primaryStage.show();
    }


}
