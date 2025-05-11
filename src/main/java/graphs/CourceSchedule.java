package graphs;

import java.util.*;

public class CourceSchedule {
    /**
     * There are a total of numCourses courses you have to take,
     * labeled from 0 to numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi]
     * indicates that you must take course bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private int UNVISITED = 0;
    private int VISITING = 1;
    private int VISITED = 2;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);


        int[] states = new int[numCourses];
        Arrays.fill(states, UNVISITED);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, states)) return false;
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int node, int[] states){
        int state = states[node];
        if (state == VISITED) return true;
        if (state == VISITING) return false;

        //UNVISITED nodes came
        //mark that node VISITING
        states[node] = VISITING;

        //iterate over all neighbor and check dfs
        for (int neighbor : graph.get(node)) {
            if (!dfs(graph, neighbor, states)) {//check if dfs return false then return false
                return false;
            }
        }

        states[node] = VISITED;//mark node VISITED
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Initialize all courses with empty lists
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        return graph;
    }
}
