import java.util.Arrays;
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
        Node.sortY(nodes);
        //System.out.println(Arrays.toString(nodes));

        Node[] topNodes = new Node[nodes.length/2];
        Node[] bottomNodes = new Node[nodes.length - nodes.length/2];

        for(int i = 0; i < bottomNodes.length; i++)
        {
            bottomNodes[i] = nodes[i];
        }
        
        for(int i = 0; i < topNodes.length; i++)
        {
            topNodes[i] = nodes[i + nodes.length/2];
        }

        System.out.println(Arrays.toString(topNodes));
        System.out.println(Arrays.toString(bottomNodes));

        Node.sortX(topNodes);
        Node.sortX(bottomNodes);
        return 0.0;
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(1,3);
        Node n2 = new Node(2,2);
        Node n3 = new Node(3,5);
        Node n4 = new Node(1,3);
        Node n5 = new Node(2,6);
        Node n6 = new Node(3,1);

        Graph g = new Graph(new Node[]{n1, n2, n3, n4, n5, n6});
        g.calculateDistance();
    }
}
