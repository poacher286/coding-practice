package tree;

import java.util.LinkedList;
import java.util.List;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        bfs(root, res, 0);
        int maxSum = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0, resSize = res.size(); i < resSize; i++) {
            List<Integer> lev = res.get(i);
            int currSum = lev.stream().mapToInt(num -> num).sum();
            if(currSum > maxSum){
                maxSum = currSum;
                ans = i;
            }
        }
        return ans + 1;
    }

    public static void bfs(TreeNode root, List<List<Integer>> res, int level){
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        bfs(root.left, res, level + 1);
        bfs(root.right, res, level + 1);
    }
}
