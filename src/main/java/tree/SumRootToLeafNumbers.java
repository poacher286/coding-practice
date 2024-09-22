package tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    /**
     * You are given the root of a binary tree containing digits from 0 to 9 only.
     *
     * Each root-to-leaf path in the tree represents a number.
     *
     * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
     * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
     *
     * A leaf node is a node with no children.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,3]
     * Output: 25
     * Explanation:
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Therefore, sum = 12 + 13 = 25.
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(root, allPaths, path);
        return allPaths.stream().mapToInt(Integer::parseInt).sum();
    }

    //preorder == root to leaf
    public void dfs(TreeNode root, List<String> allPaths, StringBuilder path) {
        if (root == null) {
            return;
        }
        path.append(root.val);
        if (root.left == null && root.right == null) {
            allPaths.add(path.toString());
        }
        dfs(root.left, allPaths, path);
        dfs(root.right, allPaths, path);
        path.deleteCharAt(path.length() - 1);
    }

    public int solve(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }
        currentSum = (currentSum * 10) + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        int leftSum = solve(root.left, currentSum);
        int rightSum = solve(root.right, currentSum);

        return leftSum + rightSum;
    }

    public int sumNumbers2(TreeNode root) {
        return solve(root, 0);
    }
}
