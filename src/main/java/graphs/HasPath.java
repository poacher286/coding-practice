package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HasPath {
    /**
     * Write a method, hasPath, that takes in an object representing the adjacency list of a directed acyclic graph and two nodes (src, dst). 
     * The method should return a boolean indicating whether or not there exists a directed path between the source and destination nodes.
     */
    public static boolean hasPath(Map<String, List<String>> graph, String src, String dst){
        //DFS Recurssion
        if (src == dst) return true;

        for (String neighbor : graph.get(src)) {
            if (hasPath(graph, neighbor, dst)) return true;
        }

        return false;
    }

    public static boolean hasPathBFS(Map<String, List<String>> graph, String src, String dst){
        //BFS use queue
        Queue<String> queue = new LinkedList<>();
        //add root to queue
        queue.offer(src);

        while (!queue.isEmpty()) {//while queue is not empty
            //remove element from queue
            String curr = queue.poll();
            //check if curr == dst
            if(curr == dst) return true;

            for (String neighbor : graph.get(curr)) {//iterate each neighbor and add to queue
                queue.offer(neighbor);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
                "f", List.of("g", "i"),
                "g", List.of("h"),
                "h", List.of(),
                "i", List.of("g", "k"),
                "j", List.of("i"),
                "k", List.of()
        );

        System.out.println(hasPath(graph, "f", "k"));
        System.out.println(hasPathBFS(graph, "f", "k"));
    }
}
