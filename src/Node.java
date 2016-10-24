/**
 * This class represents a node. There are a few differences between this and a typical node
 * because of the unique nature of the Travelling Salesman Problem (TSP). For one, each node will
 * have coordinates because the TSP requires distances. As well, the solution to the TSP is always
 * a cycle, so each node will have at most two neighbors.
 *
 * @author Arun Arjunakani
 * @version 1.0
 * @since 2016-10-24
 */

public class Node
{
    //Initializing variables
    private double x;
    private double y;
    private Node n1;
    private Node n2;

    public Node(double x, double y)
    {
        //Declare variables
        this(x, y, null, null);
    }


    public Node(double x, double y, Node n1, Node n2)
    {
        //Declare variables
        this.x = x;
        this.y = y;
        this.n1 = n1;
        this.n2 = n2;
    }

    /**
     * Returns the X coordinate
     * @param none
     * @return x
     */
    public double getX()
    {
        return x;
    }


    /**
     * Returns the Y coordinate
     * @param none
     * @return y
     */
    public double getY()
    {
        return y;
    }

    /**
     * Changes the X coordinate
     * @param x The new x Value
     * @return null
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * Changes the Y coordinate
     * @param y The new y Value
     * @return null
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int numNeighbors()
    {
        int neighbors = 0;
        neighbors = this.n1 == null? this.n2 == null ? 0: 1: 2;
        return neighbors;
    }
}
