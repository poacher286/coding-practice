package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestComponent {
    /**
     * Write a method, largestComponent, that takes in the adjacency list of an undirected graph.
     * The method should return the size of the largest connected component in the graph.
     */
    public static int largestComponent(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int largest = 0;
        for (int node : graph.keySet()) {
            int current = exploreSizeDFS(graph, node, visited);
            largest = Math.max(largest, current);
        }
        return largest;
    }

    public static int exploreSizeDFS(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        //base case
        //if node in visited set ten return 0;
        if (visited.contains(node)) return 0;

        //add in visited
        visited.add(node);

        //init size
        int size = 1;

        //iterate through all neighbors
        for (int neighbor : graph.get(node)) {
            //recurssive check all neighbors
            size += exploreSizeDFS(graph, neighbor, visited);
        }

        return size;
    }

    public static void main(String[] args) {
        System.out.println(largestComponent((Map.of(
                0, List.of(8, 1, 5),
                1, List.of(0),
                5, List.of(0, 8),
                8, List.of(0, 5),
                2, List.of(3, 4),
                3, List.of(2, 4),
                4, List.of(3, 2)
        ))));

    }
}
