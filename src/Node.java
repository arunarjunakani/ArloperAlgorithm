/**
 * This class represents a node. There are a few differences between this and a typical node
 * because of the unique nature of the Travelling Salesman Problem (TSP). For one, each node will
 * have coordinates because the TSP requires distances. As well, the solution to the TSP is always
 * a cycle, so each node will have at most two neighbors.
 *
 * @author Arun Arjunakani
 * @version 1.0
 * @since 2016-11-1
 */

public class Node
{
    //Initializing variables
    private double x;
    private double y;
    private Node n1;
    private Node n2;
    
    /**
    * Constuctor with position
    */
    public Node(double x, double y)
    {
        //Declare variables
        this(x, y, null, null);
    }

    /**
    * Constuctor with position and neighbors
    */
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
     * @param null
     * @return double
     */
    public double getX()
    {
        return x;
    }


    /**
     * Returns the Y coordinate
     * @param null
     * @return double
     */
    public double getY()
    {
        return y;
    }

    /**
     * Changes the X coordinate
     * @param double
     * @return null
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * Changes the Y coordinate
     * @param double
     * @return null
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * This counts the number of neighbors with a handy 
     * @param null
     * @return int
     */
    public int numNeighbors()
    {
        return this.n1 == null? this.n2 == null ? 0: 1: 2;
    }
    
    /** 
     * This calculates the distance between two nodes
     * @param Node, Node
     * @return double
     */
    public static double calculateDistance(Node n1, Node n2)
    {
        return Math.sqrt((n1.getX - n2.getX)*(n1.getX - n2.getX) + (n1.getY - n2.getY)*(n1.getY - n2.getY));
    }
}
