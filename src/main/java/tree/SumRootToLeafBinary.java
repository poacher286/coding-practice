package tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafBinary {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> allpaths = new ArrayList<>();
        String path = "";
        dfs(root, allpaths, path);
        return allpaths.stream()
                .map(x -> Integer.parseInt(x, 2))
                .reduce(0, Integer::sum);
    }

    public void dfs(TreeNode root, List<String> allpaths, String path){
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            allpaths.add(path);
        }
        dfs(root.left, allpaths, path);
        dfs(root.right, allpaths, path);
        path = path.substring(0, path.length() - 1);
    }

    public void dfs(TreeNode root, List<List<Integer>> allpaths, List<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null){
            allpaths.add(new ArrayList<>(path));
        }
        dfs(root.left, allpaths, path);
        dfs(root.right, allpaths, path);
        path.remove(path.size() - 1);
    }
}
