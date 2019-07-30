package main.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map; 

//This class represents a directed graph using adjacency list 
//representation 
public class BFSAlgorithm 
{ 
 
 private Map<Integer,LinkedList<Integer>> adj; //Adjacency Lists 

 // Constructor 
 BFSAlgorithm() 
 {  
     adj = new HashMap<>(); 
 } 

 // Function to add an edge into the graph 
 void addEdge(int v,int w) 
 { 
	 if(adj.containsKey(v)) {
		 adj.get(v).add(w);
	 }else {
		 adj.put(v, new LinkedList<Integer>(Arrays.asList(w)));
	 }
 } 
 
 int noOfVertices() {
	 return adj.keySet().size();
 }

 // prints BFS traversal from a given source s 
 void BFS(int s) 
 { 
     // Mark all the vertices as not visited(By default 
     // set as false) 
     Map<Integer,Boolean> visited = new HashMap<>(); 

     // Create a queue for BFS 
     LinkedList<Integer> queue = new LinkedList<Integer>(); 

     // Mark the current node as visited and enqueue it 
     visited.put(s,true); 
     queue.add(s); 

     while (queue.size() != 0) 
     { 
         // Dequeue a vertex from queue and print it 
         s = queue.poll(); 
         System.out.print(s+" "); 

         // Get all adjacent vertices of the dequeued vertex s 
         // If a adjacent has not been visited, then mark it 
         // visited and enqueue it 
         Iterator<Integer> i = adj.get(s).listIterator(); 
         while (i.hasNext()) 
         { 
             int n = i.next(); 
             if (!visited.containsKey(n)) 
             { 
                 visited.put(n, true); 
                 queue.add(n); 
             } 
         } 
     } 
 } 

 // Driver method to 
 public static void main(String args[]) 
 { 
	 BFSAlgorithm g = new BFSAlgorithm(); 

     g.addEdge(0, 1); 
     g.addEdge(0, 12); 
     g.addEdge(1, 12); 
     g.addEdge(12, 0); 
     g.addEdge(12, 3); 
     g.addEdge(3, 12); 

     System.out.println("Following is Breadth First Traversal "+ 
                        "(starting from vertex 2)"); 

     System.out.println("\ntraversing...\n");
     g.BFS(12);
     System.out.println("\n");
     System.out.println("no of vertices...  " + g.noOfVertices());
 } 
} 
//This code is contributed by Aakash Hasija 