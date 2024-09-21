package tree;

public class IsSubTree {
    /**
     * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
     *
     * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        // Recursively check the left and right subtrees of 'root'
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;  // Both trees are empty
        }
        if (root == null || subRoot == null) {
            return false; // One tree is empty and the other is not
        }
        // Check if the current nodes are equal and recursively check left and right subtrees
        return (root.val == subRoot.val) && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
