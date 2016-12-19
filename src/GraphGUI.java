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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import javafx.event.*;
import javafx.scene.input.KeyEvent;

public class GraphGUI extends Application
{
    ArrayList<Node> nodes;
    Canvas rightPane;
    TextArea result;
    GraphicsContext gc;
    boolean shown = false;

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
        SplitPane main = new SplitPane();
        main.setDividerPositions(0.125);
        Scene scene = new Scene(main, 800, 600);
        VBox leftPane = new VBox(0);
        leftPane.setId("menu");
        String[] buttons = {"Calculate", "Manual Input", "Random Graph", "Clear"};
        for(String s: buttons){
            Button b = new Button();
            b.setText(s);
            b.setPrefWidth(145);
            b.setOnAction((ActionEvent e) -> {
                switch(((Button) e.getTarget()).getText()){
                    case "Calculate":
                        drawGraph();
                        break;
                    case "Manual Input":
                        manualInput();
                        break;
                    case "Random Graph":
                        randomize();
                        break;
                    case "Clear":
                        clear();
                        break;
                }
            });

            b.setOnKeyPressed((KeyEvent e) -> {
                {
                    switch (e.getCode()) // Checks to see what key was
                    // pressed
                    {
                        case DIGIT1:
                            drawGraph();
                            break;
                        case DIGIT2:
                            manualInput();
                            break;
                        case DIGIT3:
                            randomize();
                            break;
                        case DIGIT4:
                            clear();
                            clearNodes();
                            break;
                        case ESCAPE:
                            primaryStage.close();
                            break;
                        case BACK_SPACE:
                            clear();
                            clearNodes();
                    }
                }
            });

            leftPane.getChildren().add(b);
        }

        result = new TextArea();
        result.setText("Distance: ");
        result.setMaxHeight(50);
        result.setEditable(false);
        leftPane.getChildren().add(result);

        rightPane = new Canvas(650, 600);

        rightPane.setOnMouseClicked((MouseEvent me) -> {

                createPoint(me.getX(), me.getY());
            }
        );

        gc = rightPane.getGraphicsContext2D();

        //main.getChildren().add(canvas);
        main.getItems().addAll(leftPane, rightPane);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Arloper's Algorithm");
        primaryStage.show();
    }

    private void createPoint(double x, double y) {
        if(shown)
        {
            clear();
            clearNodes();
            shown = false;
        }
        gc.fillOval(x, y, 3, 3);
        nodes.add(new Node(x, y));
    }

    private void randomize() {
        clear();
        clearNodes();
        int numNodes = new Random().nextInt(100);

        for(int i = 0; i < numNodes; i++){
            nodes.add(new Node(new Random().nextInt(650), new Random().nextInt(600)));
        }
        drawGraph();
    }

    private void manualInput() {
        TextInputDialog xValue = new TextInputDialog();
        xValue.setHeaderText(null);
        xValue.setContentText("Enter the x value of the point: ");
        Optional<String> xResult = xValue.showAndWait();
        double x = 0;
        if(xResult.isPresent())
        {
            x = Double.parseDouble(xResult.get());
        }

        TextInputDialog yValue = new TextInputDialog();
        yValue.setHeaderText(null);
        yValue.setContentText("Enter the y value of the point: ");
        Optional<String> yResult = yValue.showAndWait();
        double y = 0;
        if(yResult.isPresent())
        {
            y = Double.parseDouble(yResult.get());
        }

        createPoint(x, y);

    }

    private void drawGraph(){
        clear();
        Node[] nodeList = new Node[nodes.size()];
        for(int i = 0; i < nodeList.length; i++)
        {
            nodeList[i] = nodes.get(i);
        }
        Graph g = new Graph(nodeList);
        result.setText("Distance:\n" + Math.round(g.calculateDistance()*1000000.0)/1000000.0);
        nodeList = g.getNodes();

        if(nodeList.length < 2){
            shown = true;
            return;
        }

        if(nodeList.length == 2){
            gc.strokeLine(nodeList[0].getX(), nodeList[0].getY(), nodeList[1].getX(), nodeList[1].getY());
            shown = true;
            return;
        }

        if(nodeList.length == 3){
            gc.strokeLine(nodeList[0].getX(), nodeList[0].getY(), nodeList[1].getX(), nodeList[1].getY());
            gc.strokeLine(nodeList[0].getX(), nodeList[0].getY(), nodeList[2].getX(), nodeList[2].getY());
            gc.strokeLine(nodeList[2].getX(), nodeList[2].getY(), nodeList[1].getX(), nodeList[1].getY());
            shown = true;
            return;
        }

        for(Node n: nodeList)
        {
            gc.strokeLine(n.getX(), n.getY(), n.getN1().getX(), n.getN1().getY());
            if(n.getN2() != null)
            {
                gc.strokeLine(n.getX(), n.getY(), n.getN2().getX(), n.getN2().getY());
            }
        }
        shown = true;
    }

    private void clear()
    {
        gc.clearRect(0, 0, rightPane.getWidth(), rightPane.getHeight());
        result.setText("Distance:");
    }

    private void clearNodes()
    {
        nodes = new ArrayList<>();
    }
}
