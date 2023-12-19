package tree;

public class CousinInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        return ((levelOf(root, xx, 0) == levelOf(root, yy, 0)) && (!isSibling(root, xx, yy)));
    }

    private boolean isSibling(TreeNode root, TreeNode x, TreeNode y) {
        if (root == null){
            return false;
        }
        return (
                (root.left == x && root.right == y) || (root.left == y && root.right == x) ||
                        (isSibling(root.left, x, y)) || (isSibling(root.right, x, y))
                );
    }

    private int levelOf(TreeNode root, TreeNode x, int level) {
        if (root == null){
            return 0;
        }
        if (root == x){
            return level;
        }
        int left = levelOf(root.left, x, level + 1);
        if (left > 0){
            return left;
        }
        return levelOf(root.right, x, level + 1);
    }

    private TreeNode findNode(TreeNode root, int x) {
        if (root == null){
            return null;
        }
        if (root.val == x){
            return root;
        }
        TreeNode left = findNode(root.left, x);
        if (left != null){
            return left;
        }
        return findNode(root.right, x);
    }
}
