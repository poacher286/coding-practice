package graphs;

import java.util.*;

public class ShortestPath {
    /**
     * Write a method, shortestPath, that takes in a list of edges for an undirected graph and two nodes (nodeA, nodeB).
     * The method should return the length of the shortest path between A and B.
     * Consider the length as the number of edges in the path, not the number of nodes.
     * If there is no path between A and B, then return -1. You can assume that A and B exist as nodes in the graph.
     */
    public static int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = buildGraph(edges);
        System.out.println(graph);

        int distance = 0;

        //set to add visited // to handle cycle
        Set<String> visited = new HashSet<>();

        //use BFS to find the shortest path
        //bfs use queue
        Queue<String> queue = new LinkedList<>();
        //add nodeA to queue
        queue.offer(nodeA);
        //add to visited
        visited.add(nodeA);

        //while queue is not empty
        //add element and remove element in queue
        while (!queue.isEmpty()) {
            int size = queue.size();

            //iterate all element in queue and deep dive in neighbors of all graph
            for (int i = 0; i < size; i++){
                String currentNode = queue.poll();

                //check currentNode == nodeB
                if (currentNode == nodeB) {
                    return distance;
                }

                //add all neighbor to queue
                for (String neighbor : graph.get(currentNode)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            distance++;//update distance after iterating through all neighbors
        }

        return -1;//nodeB not reachable
    }

    public static Map<String, List<String>> buildGraph(List<List<String>> edges){
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> edge : edges) {
            String a = edge.get(0);
            String b = edge.get(1);
            if (!graph.containsKey(a)) graph.put(a, new ArrayList<>());
            if (!graph.containsKey(b)) graph.put(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return graph;
    }

    public static void main(String[] args) {
        List<List<String>> edges = List.of(
                List.of("w", "x"),
                List.of("x", "y"),
                List.of("z", "y"),
                List.of("z", "v"),
                List.of("w", "v")
        );

        System.out.println(shortestPath(edges, "w", "z"));
    }
}
