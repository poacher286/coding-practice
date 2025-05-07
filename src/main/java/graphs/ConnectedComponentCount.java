package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponentCount {
    /**
     * Write a method, connectedComponentsCount,
     * that takes in the adjacency list of an undirected graph.
     * The method should return the number of connected components within the graph.
     */
    public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int node : graph.keySet()){
            if (checkConnectedDFS(graph, node, visited)) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkConnectedDFS(Map<Integer, List<Integer>> graph, int curr, Set<Integer> visited){
        //dfs recurssive
        if (visited.contains(curr)) return false;
        visited.add(curr);

        for (int neighbor : graph.get(curr)) {
            checkConnectedDFS(graph, neighbor, visited);
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(connectedComponentsCount(Map.of(
                0, List.of(8, 1, 5),
                1, List.of(0),
                5, List.of(0, 8),
                8, List.of(0, 5),
                2, List.of(3, 4),
                3, List.of(2, 4),
                4, List.of(3, 2)
        )));// 2
    }
}
