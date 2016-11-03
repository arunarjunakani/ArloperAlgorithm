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
     * @return null
     */
    public void calculateDistance()
    {

    }
}
