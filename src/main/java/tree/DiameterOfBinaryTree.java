package tree;

public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        heightOfTree(root);
        return diameter - 1;
    }

    int heightOfTree(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(dia, diameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
