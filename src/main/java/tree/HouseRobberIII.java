package tree;

public class HouseRobberIII {
    /**
     * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
     *
     * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
     *
     * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
     */
    public int rob(TreeNode root) {
        int[] result = robSubtree(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robSubtree(TreeNode root){
        // Use post-order traversal with dynamic programming to track two scenarios at each node:
        // Rob this node: then you cannot rob its children.
        // Don't rob this node: then you are free to rob its children.

        if(root == null) return new int[2];

        int[] left = robSubtree(root.left);
        int[] right = robSubtree(root.right);

        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}
