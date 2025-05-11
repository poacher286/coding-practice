package graphs;

import java.util.*;

public class ValidPath {
    /**
     * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
     *
     * You want to determine if there is a valid path that exists from vertex source to vertex destination.
     *
     * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
     * @param n
     * @param edges
     * @param source
     * @param destination
     * @return
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        //bfs use queue
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == destination) return true;

            for (int neighbor : graph.get(curr)){
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        Set<Integer> visited = new HashSet<>();
        return dfsExplore(graph, source, destination, visited);
    }

    private boolean dfsExplore(Map<Integer, List<Integer>> graph, int source, int destination, Set<Integer> visited) {
        if (source == destination) return true;

        if (visited.contains(source)) return false;
        visited.add(source);

        for (int neighbor : graph.get(source)) {
            if (dfsExplore(graph, neighbor, destination, visited)) return true;
        }
        return false;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }

    public static void main(String[] args) {
        ValidPath vp = new ValidPath();
        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source = 0, destination = 5;
        System.out.println(vp.validPath(n, edges, source, destination));
    }

}
