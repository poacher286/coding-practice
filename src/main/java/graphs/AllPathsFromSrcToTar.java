package graphs;

import java.util.*;

public class AllPathsFromSrcToTar {
    /**
     * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
     * <p>
     * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
     *
     * @param adj
     * @return
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] adj) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        int src = 0;
        int tar = adj.length - 1;

        Queue<List<Integer>> queue = new LinkedList<>();//queue of path
        currPath.add(src);
        queue.offer(currPath);

        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int currNode = path.get(path.size() - 1);
            if (currNode == tar) {
                ans.add(new ArrayList<>(path));
            }else{
                for (int neighbor : adj[currNode]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.offer(newPath);
                }
            }
        }

        return ans;

    }

    public static List<List<Integer>> allPathsSourceTargetDFS(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int src = 0;
        int tar = graph.length - 1;
        path.add(src);
        dfs(graph, src, tar, path, ans);
        return ans;
    }

    private static void dfs(int[][] graph, int node, int tar, List<Integer> path, List<List<Integer>> ans) {
        if (node == tar) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : graph[node]) {
            path.add(neighbor);
            dfs(graph, neighbor, tar, path, ans);
            path.remove(path.size() - 1);//backtrack
        }

    }

    public static void main(String[] args) {
        int[][] adj  = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(adj));
    }
}
