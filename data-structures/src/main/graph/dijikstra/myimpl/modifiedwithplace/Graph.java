package main.graph.dijikstra.myimpl.modifiedwithplace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//now we must create graph object and implement dijkstra algorithm
public class Graph {
	private Node[] nodes;
	private int noOfNodes;
	private Edge[] edges = new Edge[0];
	private int noOfEdges;
	@SuppressWarnings("rawtypes")
	private List placeArray = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public void addEdge(String fromPlace,String toPlace,int length) {
		int fromIndex = 0;
		int toIndex = 0;
		if(!placeArray.contains(fromPlace)) {
			fromIndex = placeArray.size();
			placeArray.add(fromPlace);
		}else {
			fromIndex = placeArray.indexOf(fromPlace);
		}
		
		if(!placeArray.contains(toPlace)) {
			toIndex = placeArray.size();
			placeArray.add(toPlace);
		}else {
			toIndex = placeArray.indexOf(toPlace);
		}
		incEgdeSize();
		this.edges[noOfEdges] = new Edge(fromIndex, toIndex, length);
		++noOfEdges;
	}

	private void incEgdeSize() {
		this.edges = Arrays.copyOf(this.edges, this.edges.length+1);
	}

	public void regroup() {
		// create all nodes ready to be updated with the edges
		this.noOfNodes = calculateNoOfNodes(edges);
		this.nodes = new Node[this.noOfNodes];
		for (int n = 0; n < this.noOfNodes; n++) {
			this.nodes[n] = new Node();
		}
		// add all the edges to the nodes, each edge added to two nodes (to and from)
		this.noOfEdges = edges.length;
		for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
			int fromIndex = edges[edgeToAdd].getFromNodeIndex();
			int toIndex = edges[edgeToAdd].getToNodeIndex();
			this.nodes[fromIndex].getEdges().add(edges[edgeToAdd]);
			this.nodes[toIndex].getEdges().add(edges[edgeToAdd]);
			
			this.nodes[fromIndex].setNodeName(placeArray.get(fromIndex));
			this.nodes[toIndex].setNodeName(placeArray.get(toIndex));
		}
	}

	private int calculateNoOfNodes(Edge[] edges) {
		int noOfNodes = 0;
		for (Edge e : edges) {
			if (e.getToNodeIndex() > noOfNodes)
				noOfNodes = e.getToNodeIndex();
			if (e.getFromNodeIndex() > noOfNodes)
				noOfNodes = e.getFromNodeIndex();
		}
		noOfNodes++;
		return noOfNodes;
	}

// next video to implement the Dijkstra algorithm !!!
	public void calculateShortestDistances() {
		// node 0 as source
		this.nodes[0].setDistanceFromSource(0);
		int nextNode = 0;
		// visit every node
		for (int i = 0; i < this.nodes.length; i++) {
			// loop around the edges of current node
			ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
			for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
				int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
				// only if not visited
				if (!this.nodes[neighbourIndex].isVisited()) {
					int tentative = this.nodes[nextNode].getDistanceFromSource()
							+ currentNodeEdges.get(joinedEdge).getLength();
					if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
						nodes[neighbourIndex].setDistanceFromSource(tentative);
					}
				}
			}
			// all neighbours checked so node visited
			nodes[nextNode].setVisited(true);
			// next node must be with shortest distance
			nextNode = getNodeShortestDistanced();
		}
	}

// now we're going to implement this method in next part !
	private int getNodeShortestDistanced() {
		int storedNodeIndex = 0;
		int storedDist = Integer.MAX_VALUE;
		for (int i = 0; i < this.nodes.length; i++) {
			int currentDist = this.nodes[i].getDistanceFromSource();
			if (!this.nodes[i].isVisited() && currentDist < storedDist) {
				storedDist = currentDist;
				storedNodeIndex = i;
			}
		}
		return storedNodeIndex;
	}

// display result
	public void printResult() {
		String output = "Number of nodes = " + this.noOfNodes;
		output += "\nNumber of edges = " + this.noOfEdges;
		for (int i = 0; i < this.nodes.length; i++) {
//			output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
			output += ("\nThe shortest distance from node "+nodes[0].getNodeName()+" to node " + nodes[i].getNodeName() + " is " + nodes[i].getDistanceFromSource());
		}
		System.out.println(output);
	}

	public Node[] getNodes() {
		return nodes;
	}

	public int getNoOfNodes() {
		return noOfNodes;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public int getNoOfEdges() {
		return noOfEdges;
	}
}