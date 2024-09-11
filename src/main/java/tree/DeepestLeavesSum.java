package tree;

import java.util.LinkedList;
import java.util.List;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        bfs(root, res, 0);
        int deepLeavesSum = 0;
        for(int leaf : res.get(res.size() - 1)){
            deepLeavesSum += leaf;
        }
        return deepLeavesSum;
    }

    public static void  bfs(TreeNode root, List<List<Integer>> res, int level){
        if (root == null) return;
        if (level >= res.size()) { // if level is more, then add empty list
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        bfs(root.left , res, level + 1);
        bfs(root.right , res, level + 1);
    }
}
