package tree;

import java.util.List;

public class PathSum3 {
    /**
     * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
     *
     * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * Output: 3
     * Explanation: The paths that sum to 8 are shown.
     * @param root
     * @param targetSum
     * @return
     */
//    public int pathSum(TreeNode root, int targetSum) {
//
//    }

    public void dfs(TreeNode root, int target, List<List<Integer>> allPaths, List<Integer> path) {
        if (root == null) {
            return;
        }

    }
}
