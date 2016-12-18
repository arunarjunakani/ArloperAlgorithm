import java.util.Arrays;

/**
 * This class represents a node. There are a few differences between this and a typical node
 * because of the unique nature of the Travelling Salesman Problem (TSP). For one, each node will
 * have coordinates because the TSP requires distances. As well, the solution to the TSP is always
 * a cycle, so each node will have at most two neighbors.
 *
 * @author Arun Arjunakani
 * @version 1.0
 * @since 2016-11-3
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

        this.setN1(n1);
        this.setN2(n2);
    }

    /**
     * Uses quicksort to sort the nodes vertically
     * @param Node[]
     * @return null
     */
    public static void sortY(Node[] arr)
    {
        sortY(arr, 0, arr.length - 1);
    }

    /**
     * Uses quicksort to sort the nodes vertically over a range
     * @param Node[], int, int
     * @return null
     */
    private static void sortY(Node[] arr, int low, int high)
    {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        double pivot = arr[middle].getY();

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i].getY() < pivot) {
                i++;
            }

            while (arr[j].getY() > pivot) {
                j--;
            }

            if (i <= j) {
                Node temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
        {
            sortY(arr, low, j);
        }

        if (high > i) {
            sortY(arr, i, high);
        }
    }

    /**
     * Uses quicksort to sort the nodes horizontally
     * @param Node[]
     * @return null
     */
    public static void sortX(Node[] arr)
    {
        sortX(arr, 0, arr.length - 1);
    }

    /**
     * Uses quicksort to sort the nodes horizontally over a range
     * @param Node[], int, int
     * @return null
     */
    private static void sortX(Node[] arr, int low, int high)
    {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        double pivot = arr[middle].getX();

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i].getX() < pivot) {
                i++;
            }

            while (arr[j].getX() > pivot) {
                j--;
            }

            if (i <= j) {
                Node temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
        {
            sortX(arr, low, j);
        }

        if (high > i) {
            sortX(arr, i, high);
        }
    }

    /**
     * Returns the first neighbor
     * @param null
     * @return Node
     */
    public Node getN1()
    {
        return n1;
    }

    /**
     * Returns the second neighbor
     * @param null
     * @return Node
     */
    public Node getN2()
    {
        return n2;
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
     * Changes the first neighbor
     * @param Node, int
     * @return null
     */
    public void setN1(Node n1)
    {
        if(n1 == null)
        {
            return;
        }

        if(n1.getN1() == null)
        {
            this.n1 = n1;
            n1.n1 = this;
        }
        else if(n1.getN2() == null)
        {
            this.n1 = n1;
            n1.n2 = this;
        }
    }

    /**
     * Changes the second neighbor
     * @param Node, int
     * @return null
     */
    public void setN2(Node n2)
    {
        if(n1 == null)
        {
            return;
        }

        if(n2.getN1() == null)
        {
            this.n2 = n2;
            n2.n1 = this;
        }
        else if(n2.getN2() == null)
        {
            this.n2 = n2;
            n2.n2 = this;
        }
    }

    /**
     * This counts the number of neighbors with a handy 
     * @param null
     * @return int
     */
    public int numNeighbors()
    {
        return this.n1 != null? this.n2 != null ? 2: 1: 0;
    }
    
    /** 
     * This calculates the distance between two nodes
     * @param Node, Node
     * @return double
     */
    public static double calculateDistance(Node n1, Node n2)
    {
        return Math.sqrt((n1.getX() - n2.getX())*(n1.getX() - n2.getX()) + (n1.getY() - n2.getY())*(n1.getY() - n2.getY()));
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }

    /**
     * This is the main method which runs the entire program.
     * @param String[]
     * @return null
     */
    public static void main(String[] args)
    {
        Node n1 = new Node(1,3);
        Node n2 = new Node(2,2);
        Node n3 = new Node(3,1);
        n3.setN1(n1);
        n3.setN2(n2);
        System.out.println(n3);
    }
}
