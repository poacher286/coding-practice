package graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFSTraversal {
    public static void printDFS(Map<Character, List<Character>> graph, Character source){
        //DFS use Stack
        Stack<Character> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            Character curr = stack.pop();
            System.out.println(curr);

            for (Character neighbor : graph.get(curr)){
                stack.push(neighbor);
            }
        }
    }

    public static void printDFSRecurssion(Map<Character, List<Character>> graph, Character source){
        //DFS using recurssion
        System.out.println(source);
        for (Character neighbor : graph.get(source)){
            printDFSRecurssion(graph, neighbor);
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

        printDFS(graph, 'a');
        printDFSRecurssion(graph, 'a');
    }
}
