package tree;

public class PruneTree {
    /**
     * Given the root of a binary tree,
     * return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
     *
     * A subtree of a node node is node plus every node that is a descendant of node.
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        return checkOne(root) ? root : null;
    }

    private boolean checkOne(TreeNode root) {
        if (root == null) return false;

        boolean left = checkOne(root.left);
        boolean right = checkOne(root.right);

        if (!left) root.left = null;
        if (!right) root.right = null;
        return root.val == 1 || left || right;
    }

    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree2(root.left);
        root.right = pruneTree2(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
