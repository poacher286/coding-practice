package tree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        //post order traversal
        // left  -> right --> root
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(temp);
        return root;
    }
}
