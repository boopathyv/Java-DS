package chapters.skillenza.fptechscience;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProperSolution {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int testCase = sc.nextInt();
			for (int i = 0; i < testCase; i++) {
				int edgeCount = sc.nextInt();
				Edge[] edges = new Edge[edgeCount-1];
				for (int j = 0; j < edgeCount-1; j++) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					edges[j] = new Edge(start, end, end);
				}
				int start = sc.nextInt();
				Graph g = new Graph(edges);
				g.calculateShortestDistances(start);
				g.printResult(start);
			}
		}
	}

	class Node {
		  private int distanceFromSource = Integer.MAX_VALUE;
		  private boolean visited;
		  private ArrayList<Edge> edges = new ArrayList<Edge>();
		  public int getDistanceFromSource() {
		    return distanceFromSource;
		  }
		  public void setDistanceFromSource(int distanceFromSource) {
		    this.distanceFromSource = distanceFromSource;
		  }
		  public boolean isVisited() {
		    return visited;
		  }
		  public void setVisited(boolean visited) {
		    this.visited = visited;
		  }
		  public ArrayList<Edge> getEdges() {
		    return edges;
		  }
		  public void setEdges(ArrayList<Edge> edges) {
		    this.edges = edges;
		  }
	}

	class Graph {
		private Node[] nodes;
		private int noOfNodes;
		private Edge[] edges;
		private int noOfEdges;

		public Graph(Edge[] edges) {
			this.edges = edges;
			this.noOfNodes = calculateNoOfNodes(edges);
			this.nodes = new Node[this.noOfNodes];
			for (int n = 0; n < this.noOfNodes; n++) {
				this.nodes[n] = new Node();
			}

			this.noOfEdges = edges.length;
			for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
				this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
				this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
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

		public void calculateShortestDistances(int start) {
			this.nodes[start].setDistanceFromSource(0);
			int nextNode = start;
			for (int i = 0; i < this.nodes.length; i++) {
				ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
				for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
					int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
					if (!this.nodes[neighbourIndex].isVisited()) {
						int tentative = this.nodes[nextNode].getDistanceFromSource()
								+ currentNodeEdges.get(joinedEdge).getLength();
						if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
							nodes[neighbourIndex].setDistanceFromSource(tentative);
						}
					}
				}
				nodes[nextNode].setVisited(true);
				nextNode = getNodeShortestDistanced();
			}
		}

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

		public void printResult(int start) {
			List<Node> nodeList = Arrays.asList(this.nodes);
			Node node = nodeList.stream().filter(data->data.getDistanceFromSource()!=Integer.MAX_VALUE)
				.max(Comparator.comparing(data -> data.getDistanceFromSource())).get();
			
			System.out.println(nodeList.indexOf(node));
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

	class Edge {
		  private int fromNodeIndex;
		  private int toNodeIndex;
		  private int length;
		  public Edge(int fromNodeIndex, int toNodeIndex, int length) {
		    this.fromNodeIndex = fromNodeIndex;
		    this.toNodeIndex = toNodeIndex;
		    this.length = length;
		  }
		  public int getFromNodeIndex() {
		    return fromNodeIndex;
		  }
		  public int getToNodeIndex() {
		    return toNodeIndex;
		  }
		  public int getLength() {
		    return length;
		  }
		  public int getNeighbourIndex(int nodeIndex) {
		    if (this.fromNodeIndex == nodeIndex) {
		      return this.toNodeIndex;
		    } else {
		      return this.fromNodeIndex;
		   }
		  }
	}