/**
 * This class deals with all of the GUI for the project. This is also has the main method to run
 * the program.
 *
 * @author Arun Arjunakani
 * @version 1.0
 * @since 2016-11-3
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.util.ArrayList;

public class GraphGUI extends Application
{
    ArrayList<Node> nodes;
    Canvas canvas;
    GraphicsContext gc;

    /**
     * This is the main method which runs the entire program.
     * @param String[]
     * @return null
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * This is the method that sets up all of the GUI. This is required in all classes that implement
     * the JavaFX Application class.
     * @param Stage
     * @return null
     */
    @Override
    public void start(Stage primaryStage)
    {
        nodes = new ArrayList<>();
        TilePane main = new TilePane();
        Scene scene = new Scene(main, 800, 600);

        VBox buttons = new VBox(8);
        Button btn = new Button("Hello");
        buttons.getChildren().add(btn);
        btn.setOnAction(event -> {
            System.out.println(btn.getText() + " was pressed!");
        });

        canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();
        gc.strokeLine(40, 10, 10, 40);

        //main.getChildren().add(canvas);
        main.getChildren().add(buttons);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Arloper's Algorithm");
        primaryStage.show();
    }

    public void drawGraph(){
        Node[] nodeList = new Node[nodes.size()];
        for(int i = 0; i < nodeList.length; i++)
        {
            nodeList[i] = nodes.get(i);
        }

        Graph g = new Graph(nodeList);

    }
}
