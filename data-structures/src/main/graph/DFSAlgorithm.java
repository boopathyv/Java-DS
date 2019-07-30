package main.graph;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map; 

//This class represents a directed graph using adjacency list 
//representation 
class DFSAlgorithm 
{ 
	private int V; // No. of vertices 

	// Array of lists for Adjacency List Representation 
	private Map<Integer,LinkedList<Integer>> adj; 

	// Constructor 
	DFSAlgorithm(int v) 
	{ 
		V = v; 
		adj = new HashMap<>(); 
		 
	} 

	//Function to add an edge into the graph 
	void addEdge(int v, int w) 
	{ 
		// Add w to v's list.
		 if(adj.containsKey(v)) {
			 adj.get(v).add(w);
		 }else {
			 adj.put(v, new LinkedList<Integer>(Arrays.asList(w)));
		 }
	} 

	// A function used by DFS 
	void DFSUtil(int v,Map<Integer,Boolean> visited) 
	{ 
		// Mark the current node as visited and print it 
		visited.put(v,true); 
		System.out.print(v+" "); 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj.get(v).listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited.containsKey(n)) 
				DFSUtil(n, visited); 
		} 
	} 

	// The function to do DFS traversal. It uses recursive DFSUtil() 
	void DFS(int v) 
	{ 
		// Mark all the vertices as not visited(set as 
		// false by default in java) 
		Map<Integer,Boolean> visited = new HashMap(); 

		// Call the recursive helper function to print DFS traversal 
		DFSUtil(v, visited); 
	} 

	public static void main(String args[]) 
	{ 
		DFSAlgorithm g = new DFSAlgorithm(4); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 

		System.out.println("Following is Depth First Traversal "+ 
						"(starting from vertex 2)"); 

		g.DFS(2); 
	} 
} 
//This code is contributed by Aakash Hasija 
