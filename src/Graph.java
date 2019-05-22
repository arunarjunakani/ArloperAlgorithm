import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

public class Graph {
	private Node[] nodes;

	public Graph(Node[] nodes) {
		this.nodes = nodes;
	}

	public double calculateDistance() {

		double distance = 0.0;

		if (nodes == null || nodes.length <= 1) {
			return distance;
		}

		if (nodes.length == 2) {
			distance = Node.calculateDistance(nodes[0], nodes[1]);
			return distance;
		}

		Arrays.sort(nodes, Comparator.comparing(Node::getY));

		//Splits the graph into top and bottom arrays and fills them
		Node[] topNodes = new Node[nodes.length / 2];
		Node[] bottomNodes = new Node[nodes.length - nodes.length / 2];

		for (int i = 0; i < bottomNodes.length; i++) {
			bottomNodes[i] = nodes[i];
		}

		if (nodes.length % 2 == 0) {
			for (int i = 0; i < topNodes.length; i++) {
				topNodes[i] = nodes[i + nodes.length / 2];
			}
		} else {
			for (int i = 0; i < topNodes.length; i++) {
				topNodes[i] = nodes[i + nodes.length / 2 + 1];
			}
		}

		Arrays.sort(topNodes, Comparator.comparing(Node::getX));
		Arrays.sort(bottomNodes, Comparator.comparing(Node::getX));

		//Connects the nodes in each array and finds distance
		for (int i = 1; i < topNodes.length; i++) {
			topNodes[i].setN1(topNodes[i - 1]);
			distance += Node.calculateDistance(topNodes[i], topNodes[i - 1]);

		}
		for (int i = 1; i < bottomNodes.length; i++) {
			bottomNodes[i].setN1(bottomNodes[i - 1]);
			distance += Node.calculateDistance(bottomNodes[i], bottomNodes[i - 1]);
		}

		//Connects the two paths and finds distance
		topNodes[0].setN2(bottomNodes[0]);
		distance += Node.calculateDistance(topNodes[0], bottomNodes[0]);

		bottomNodes[bottomNodes.length - 1].setN2(topNodes[topNodes.length - 1]);
		distance += Node.calculateDistance(bottomNodes[bottomNodes.length - 1], topNodes[topNodes.length - 1]);

		ArrayList<Node> sorted = new ArrayList<>(topNodes.length + bottomNodes.length);
		Collections.addAll(sorted, topNodes);
		Collections.addAll(sorted, bottomNodes);

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = sorted.get(i);
		}


		return distance;
	}

	public Node[] getNodes() {
		return nodes;
	}
}
