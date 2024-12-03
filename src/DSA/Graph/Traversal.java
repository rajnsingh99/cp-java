package DSA.Graph;

import java.util.ArrayList;
import java.util.List;

public class Traversal {

    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 5;

        // Adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS starting from 0:");
        bfsTraversal(adj, 0);
    }

    private static void bfsTraversal(List<List<Integer>> adjList, int node) {
        List<Integer> visited = new ArrayList<>();
        bfs(adjList, visited, 0);
    }

    private static void bfs(List<List<Integer>> adjList, List<Integer> visited, int node) {
        System.out.println("Visited " + node);
        visited.set(node, 1);


    }


    // Function to add an edge to the graph
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph
    }
}
