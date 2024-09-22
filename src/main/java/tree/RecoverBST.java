package tree;

public class RecoverBST {
    /**
     * You are given the root of a binary search tree (BST),
     * where the values of exactly two nodes of the tree were swapped by mistake.
     * Recover the tree without changing its structure.
     *
     * @param root
     */
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode previous = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (previous != null && previous.val > root.val) {//wrong bst
            if (first == null) {
                first = previous;
            }
            second = root;
        }
        previous = root;
        inorder(root.right);
    }
}
