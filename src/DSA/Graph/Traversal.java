package DSA.Graph;

import java.util.*;

public class Traversal {

    public static void main(String[] args)
    {
        int V = 5; // Number of vertices in the graph

        // Create an adjacency list for the graph
        List<List<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the edges of the graph
        int[][] edges = {
                { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };

        // Populate the adjacency list with edges
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        System.out.println("DFS from source: " + source);
        for (List<Integer> vertices : adj) {
            System.out.println(vertices);
        }
    }

    // Function to add an edge to the adjacency list
    static void addEdge(List<List<Integer> > adj,
                        int s, int t){
        // Add edge from vertex s to t
        adj.get(s).add(t);
    }

    private static void bfsTraversal(Map<Integer, List<Integer>> graph) {
        boolean[] visited = bfs(graph, 0);
        System.out.println(Arrays.toString(visited));
    }

    private static boolean[] bfs(Map<Integer, List<Integer>> graph, int node) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println(curr);
            visited[curr] = true;
            for (Integer vertices : graph.get(curr)) {
                if(!visited[vertices]) {
                    queue.add(vertices);
                }
            }
        }

        return visited;
    }



    private static void dfs() {

    }

}
