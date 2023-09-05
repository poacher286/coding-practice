package tree;

import java.util.ArrayList;
import java.util.List;

public class BinTreePostorderTraversal {
    /**
     * leftsubtree -> right subtree -> root
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode treeNode = BinaryTree.buildTree(nodes);
        System.out.println(postOrderTraversal(treeNode));

    }

}
