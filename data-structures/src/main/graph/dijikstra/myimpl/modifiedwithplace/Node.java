package main.graph.dijikstra.myimpl.modifiedwithplace;

import java.util.ArrayList;

public class Node {
	  private int distanceFromSource = Integer.MAX_VALUE;
	  private boolean visited;
	  private Object nodeName;
	  private ArrayList<Edge> edges = new ArrayList<Edge>(); // now we must create edges
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
	  public void setNodeName(Object nodeName) {
		this.nodeName = nodeName;
	  }
	  
	  public Object getNodeName() {
		return this.nodeName;
	  }
}