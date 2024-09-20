package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null){
            return paths;
        }
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> allPath = new ArrayList<>();
        dfs(root, path, allPath);
        paths = allPath.stream()
                .map(x -> x.stream().map(String::valueOf).collect(Collectors.joining("->")))
                .collect(Collectors.toList());
        return paths;
    }

    public void dfs(TreeNode root, List<Integer> path, List<List<Integer>> allPath){
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            allPath.add(new ArrayList<>(path));
        }
        dfs(root.left, path, allPath);
        dfs(root.right, path, allPath);
        path.remove(path.size() - 1);
    }
}
