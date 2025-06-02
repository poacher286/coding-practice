package tree;

import java.util.Stack;

public class AverageOfSubtree {
    /**
     * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
     *
     * Note:
     *
     * The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
     * A subtree of root is a tree consisting of root and all of its descendants.
     * @param root
     * @return
     */
    public int averageOfSubtree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            //add to res
            if (root.val == calculateSum(root, 0) / countNodes(root)){
                count++;
            }
            root = root.right;
        }

        return count;
    }

    int count = 0;

    public int averageOfSubtreeRecurr(TreeNode root) {
        dfs(root);
        return count;
    }

    private void dfs(TreeNode root){
        if (root != null){
            dfs(root.left);
            if (root.val == calculateSum(root, 0) / countNodes(root)){
                count++;
            }
            dfs(root.right);
        }
    }

    private int countNodes(TreeNode root){
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int calculateSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return sum + root.val +
                calculateSum(root.left, sum) + calculateSum(root.right, sum);
    }
}
