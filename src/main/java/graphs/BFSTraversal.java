package graphs;

import java.util.*;

public class BFSTraversal {

    public static void printBFS(Map<Character, List<Character>> graph, Character source){
        //BFS use queue
        Queue<Character> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            System.out.println(curr);
            for (Character neighbor : graph.get(curr)) {
                queue.offer(neighbor);
            }
        }

    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', List.of('b', 'c'));
        graph.put('b', List.of('d'));
        graph.put('c', List.of('e'));
        graph.put('d', List.of('f'));
        graph.put('e', List.of());
        graph.put('f', List.of());

        printBFS(graph, 'a');
    }
}
