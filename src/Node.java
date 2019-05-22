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

public class Node {
	//Initializing variables
	private double x;
	private double y;
	private Node n1;
	private Node n2;

	public Node(double x, double y) {
		//Declare variables
		this(x, y, null, null);
	}

	public Node(double x, double y, Node n1, Node n2) {
		//Declare variables
		this.x = x;
		this.y = y;

		this.setN1(n1);
		this.setN2(n2);
	}

	public Node getN1() {
		return n1;
	}

	public Node getN2() {
		return n2;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setN1(Node n1) {
		if (n1 == null) {
			return;
		}

		if (n1.getN1() == null) {
			this.n1 = n1;
			n1.n1 = this;
		} else if (n1.getN2() == null) {
			this.n1 = n1;
			n1.n2 = this;
		}
	}

	public void setN2(Node n2) {
		if (n1 == null) {
			return;
		}

		if (n2.getN1() == null) {
			this.n2 = n2;
			n2.n1 = this;
		} else if (n2.getN2() == null) {
			this.n2 = n2;
			n2.n2 = this;
		}
	}

	public int numNeighbors() {
		return this.n1 != null ? this.n2 != null ? 2 : 1 : 0;
	}

	public static double calculateDistance(Node n1, Node n2) {
		return Math.sqrt((n1.getX() - n2.getX()) * (n1.getX() - n2.getX()) + (n1.getY() - n2.getY()) * (n1.getY() - n2.getY()));
	}

	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}
}
