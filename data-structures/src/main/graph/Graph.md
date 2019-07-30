# Graph

>> * Vertices(Nodes) , Edges 
>> * A graph can be defined as group of vertices and edges that are used to connect these vertices. A graph can be seen as a cyclic tree, where the vertices (Nodes) maintain any complex relationship among them instead of having parent child relationship.

Following two are the most commonly used representations of a graph.
1. Adjacency Matrix
2. Adjacency List

## Directed and Undirected Graph

# Representation
>> * ordered set G(V, E)
>> * V(G) represents the set of vertices
>> * E(G) represents the set of edges
>> * G(V, E) with 5 vertices (A, B, C, D, E) and six edges ((A,B), (B,C), (C,E), (E,D), (D,B), (D,A))

# Path
>> * A path can be defined as the sequence of nodes that are followed in order to reach some terminal node V from the initial node U.

# Closed Path
>> * A path will be called as closed path if the initial node is same as terminal node. A path will be closed path if V0=VN.

# Simple Path
>> * If all the nodes of the graph are distinct with an exception V0=VN, then such path P is called as closed simple path.

# Cycle
>> * A cycle can be defined as the path which has no repeated edges or vertices except the first and last vertices.

# Connected Graph
>> * A connected graph is the one in which some path exists between every two vertices (u, v) in V. There are no isolated nodes in connected graph.

# Complete Graph
>> * A complete graph is the one in which every node is connected with all other nodes. A complete graph contain n(n-1)/2 edges where n is the number of nodes in the graph.

# Weighted Graph
>> * In a weighted graph, each edge is assigned with some data such as length or weight. The weight of an edge e can be given as w(e) which must be a positive (+) value indicating the cost of traversing the edge.

# Digraph
>> * A digraph is a directed graph in which each edge of the graph is associated with some direction and the traversing can be done only in the specified direction.

# Loop
>> * An edge that is associated with the similar end points can be called as Loop.

# Adjacent Nodes
>> * If two nodes u and v are connected via an edge e, then the nodes u and v are called as neighbours or adjacent nodes.

# Degree of the Node
>> * A degree of a node is the number of edges that are connected with that node. A node with degree 0 is called as isolated node.

# Traversal Algorithm
>> * Breadth First Search
>> * Depth First Search

# BFS
# DFS
>> * The data structure which is being used in DFS is stack. The process is similar to BFS algorithm. In DFS, the edges that leads to an *unvisited node* are called *discovery edges* while the edges that leads to an *already visited node* are called *block edges*.

# Dijikstra Algorithm
https://medium.com/@ssaurel/calculate-shortest-paths-in-java-by-implementing-dijkstras-algorithm-5c1db06b6541