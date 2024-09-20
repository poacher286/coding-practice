package tree;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 ? right :
                right == 0 ? left :
                Math.min(left, right) + 1;
    }
}
