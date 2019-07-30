package main.graph.dijikstra.myimpl.distancefromanysource;

public class Main {
	  public static void main(String[] args) {
		  
		  
		  // 0 = Shollinganallur
		  // 1 = ecr_water_tank
		  // 2 = karapakkam
		  // 3 = medavakkam
		  // 4 = navalur
		  // 5 = mayajal
		  // 6 = tidel
		  // 7 = velachery
		  
//	    Edge[] edges = {
//	      new Edge(0, 2, 1), new Edge(0, 3, 4), new Edge(0, 4, 2),
//	      new Edge(0, 1, 3), new Edge(1, 3, 2), new Edge(1, 4, 3),
//	      new Edge(1, 5, 1), new Edge(2, 4, 1), new Edge(3, 5, 4),
//	      new Edge(4, 5, 2), new Edge(4, 6, 7), new Edge(4, 7, 2),
//	      new Edge(5, 6, 4), new Edge(6, 7, 5)
//	    };
		
		  
	    Graph g = new Graph();
	    g.addEdge("Shollinganallur", "karapakkam", 2);
	    g.addEdge("Shollinganallur", "medavakkam", 4);
	    g.addEdge("Shollinganallur", "navalur", 7);
	    g.addEdge("Shollinganallur", "ecr_water_tank", 3);
	    g.addEdge("ecr_water_tank", "medavakkam", 7);
	    g.addEdge("ecr_water_tank", "navalur", 10);
	    g.addEdge("ecr_water_tank", "mayajal", 6);
	    g.addEdge("karapakkam", "navalur", 8);
	    g.addEdge("medavakkam", "mayajal", 13);
	    g.addEdge("navalur", "mayajal", 17);
	    g.addEdge("navalur", "tidel", 16);
	    g.addEdge("navalur", "velachery", 20);
	    g.addEdge("mayajal", "tidel", 19);
	    g.addEdge("tidel", "velachery", 4);
	    
	    g.regroup();
	    System.out.println("");
	    
	    g.getShortestRoute("ecr_water_tank","tidel");
//	    g.calculateShortestDistances();
//	    g.printResult(); // let's try it !
	  }
}