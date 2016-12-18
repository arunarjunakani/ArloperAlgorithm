import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This class represents a graph. There are a few differences between this and a typical graph.
 * While this class has a set of nodes, it does not take into account the edges between the nodes
 * (that is taken care of in the Node class). This is essentially just a list of nodes with a calculateDistance()
 * method that implements the Arloper algorithm.
 *
 * @author Arun Arjunakani
 * @version 1.0
 * @since 2016-11-3
 */

public class Graph
{
    Node[] nodes;

    /**
     * Only constuctor
     */
    public Graph(Node[] nodes)
    {
        this.nodes = nodes;
    }


    /**
     * Calculating the distance of the graph if Arloper's Algorithm is used.
     * @param null
     * @return double
     */
    public double calculateDistance()
    {
        double distance = 0.0;
        Node.sortY(nodes);
        //System.out.println(Arrays.toString(nodes));

        //Splits the graph into top and bottom arrays and fills them
        Node[] topNodes = new Node[nodes.length/2];
        Node[] bottomNodes = new Node[nodes.length - nodes.length/2];

        for(int i = 0; i < bottomNodes.length; i++)
        {
            bottomNodes[i] = nodes[i];
        }

        if(nodes.length % 2 == 0) {
            for(int i = 0; i < topNodes.length; i++)
            {
                topNodes[i] = nodes[i + nodes.length/2];
            }
        }
        else {
            for(int i = 0; i < topNodes.length; i++)
            {
                topNodes[i] = nodes[i + nodes.length/2 + 1];
            }
        }


        System.out.println(Arrays.toString(topNodes));
        System.out.println(Arrays.toString(bottomNodes));

        //Sorts the arrays horizontally
        Node.sortX(topNodes);
        Node.sortX(bottomNodes);

        //Connects the nodes in each array and finds distance
        for(int i = 1; i < topNodes.length; i++)
        {
            topNodes[i].setN1(topNodes[i-1]);
            distance += Node.calculateDistance(topNodes[i], topNodes[i-1]);

        }
        for(int i = 1; i < bottomNodes.length; i++)
        {
            bottomNodes[i].setN1(bottomNodes[i-1]);
            distance += Node.calculateDistance(bottomNodes[i], bottomNodes[i-1]);
        }

        //Connects the two paths and finds distance
        topNodes[0].setN2(bottomNodes[0]);
        distance += Node.calculateDistance(topNodes[0], bottomNodes[0]);

        bottomNodes[bottomNodes.length-1].setN2(topNodes[topNodes.length-1]);
        distance += Node.calculateDistance(bottomNodes[bottomNodes.length-1], topNodes[topNodes.length-1]);

        ArrayList<Node> sorted = new ArrayList<>(topNodes.length + bottomNodes.length);
        Collections.addAll(sorted, topNodes);
        Collections.addAll(sorted, bottomNodes);

        for(int i = 0; i < nodes.length; i++)
        {
            nodes[i] = sorted.get(i);
        }

        System.out.println(distance);
        return distance;
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(1,1);
        Node n2 = new Node(2,2);
        Node n3 = new Node(1,2);


        Graph g = new Graph(new Node[]{n1, n2, n3});
        double distance = g.calculateDistance();
    }
}
