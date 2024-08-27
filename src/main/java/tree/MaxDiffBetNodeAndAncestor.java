package tree;

public class MaxDiffBetNodeAndAncestor {
    /**
     * Given the root of a binary tree,
     * find the maximum value v for which there exist different nodes a and b
     * where v = |a.val - b.val| and a is an ancestor of b.
     *
     * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {
        int min = root.val;
        int max = root.val;
        return dfs(root, min, max);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null){
            return 0;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        if (root.left != null){
            leftMax = dfs(root.left, min, max);
        }
        if (root.right != null) {
            rightMax = dfs(root.right, min, max);
        }
        return Math.max(max - min, Math.max(leftMax, rightMax));

    }

}
