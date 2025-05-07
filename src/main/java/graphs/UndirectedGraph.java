package graphs;

import java.util.*;

public class UndirectedGraph {
    /**
     * Write a method, undirectedPath, that takes in a list of edges for an undirected graph and two nodes (nodeA, nodeB).
     * The method should return a boolean indicating whether or not there exists a path between nodeA and nodeB.
     */
    public static boolean undirectedPath(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = buildGraph(edges);

        return hasPathDFS(graph, nodeA, nodeB, new HashSet<>());
    }

    public static boolean hasPathDFS(Map<String, List<String>> graph , String src, String dst, Set<String> visited){
        if (src == dst) return true;
        if (visited.contains(src)) return false;
        visited.add(src);

        for (String neighbor : graph.get(src)) {
            if (hasPathDFS(graph, neighbor, dst, visited)) {
                return true;
            }
        }
        return false;
    }


    public static Map<String, List<String>> buildGraph(List<List<String>> edges){
        //[[i, j], [k, i], [m, k]]
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
                List.of("i", "j"),
                List.of("k", "i"),
                List.of("m", "k"),
                List.of("k", "l"),
                List.of("o", "n")
        );

        System.out.println(buildGraph(edges));//{i=[j, k], j=[i], k=[i, m, l], l=[k], m=[k], n=[o], o=[n]}
        System.out.println(undirectedPath(edges, "i", "o"));
    }
}
