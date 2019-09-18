package chapters.skillenza.fptechscience;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class solution {
	
	public static void main(String[] args) {
//			Edge[] edges = {new Edge(7,2,2),
//					new Edge(7,3,3),
//					new Edge(7,6,6),
//					new Edge(7,4,4),
//					new Edge(7,10,10),
//					new Edge(3,5,5),
//					new Edge(6,8,8),
//					new Edge(6,1,1),
//					new Edge(8,9,9)};
		Edge[] edges = {new Edge(5,6,6),
				new Edge(5,2,2),
				new Edge(6,4,4),
				new Edge(6,3,3),
				new Edge(4,7,7),
				new Edge(7,1,1)};
			int start = 5;
			Graph g = new Graph(edges);
			g.calculateShortestDistances(start,0);
			g.printResult(start);
	}

		
	public static void mainx(String[] args) {
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
					g.calculateShortestDistances(start,0);
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

				this.noOfEdges = edges.length;
				for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
					if(this.nodes[edges[edgeToAdd].getFromNodeIndex()] == null) {
						this.nodes[edges[edgeToAdd].getFromNodeIndex()] = new Node();
					}
					if(this.nodes[edges[edgeToAdd].getToNodeIndex()] == null) {
						this.nodes[edges[edgeToAdd].getToNodeIndex()] = new Node();
					}
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

			public void calculateShortestDistances(int nextNode,int distance) {
				this.nodes[nextNode].setDistanceFromSource(distance);
				ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
				for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
					int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
					if (!this.nodes[neighbourIndex].isVisited()) {
						int tentative = this.nodes[nextNode].getDistanceFromSource()
								+ currentNodeEdges.get(joinedEdge).getLength();
						if (tentative < this.nodes[neighbourIndex].getDistanceFromSource()) {
							this.nodes[neighbourIndex].setDistanceFromSource(tentative);
						}
					}
				}
				this.nodes[nextNode].setVisited(true);
				nextNode = getNodeShortestDistanced();
				if(nextNode != Integer.MAX_VALUE) {
					calculateShortestDistances(nextNode,this.nodes[nextNode].getDistanceFromSource());
				}
			}

			private int getNodeShortestDistanced() {
				int storedNodeIndex = 0;
				int storedDist = Integer.MAX_VALUE;
				for (int i = 0; i < this.nodes.length ; i++) {
					if(this.nodes[i] != null) {
						int currentDist = this.nodes[i].getDistanceFromSource();
						if (!this.nodes[i].isVisited() && currentDist < storedDist) {
							storedDist = currentDist;
							storedNodeIndex = i;
						}
					}
				}
				if(storedDist == Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				return storedNodeIndex;
			}

			public void printResult(int start) {
				List<Node> nodeList = Arrays.asList(this.nodes);
				Node node = nodeList.stream().filter(data->data != null)
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