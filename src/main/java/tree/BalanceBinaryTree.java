package tree;

public class BalanceBinaryTree {
    boolean balance = true;

    /**
     * Given a binary tree, determine if it is height-balanced.
     * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
     */
    public boolean isBalanced(TreeNode root) {
        heightCheckBalance(root);
        return balance;
    }

    public int heightCheckBalance(TreeNode root){
        if (root == null) return 0;

        int left = heightCheckBalance(root.left);
        int right = heightCheckBalance(root.right);

        //check if height is balance
        if (Math.abs(left - right) > 1) balance = false;
        return 1 + Math.max(left, right);
    }
}
