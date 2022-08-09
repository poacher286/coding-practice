package tree;

public class BST {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean check(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        if (!(node.val < right && node.val > left)) {
            return false;
        }

        return check(node.left, left, node.val) && check(node.right, node.val, right);
    }
}
