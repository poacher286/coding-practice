package tree;

import java.util.ArrayList;
import java.util.List;

public class BinTreePreorderTraversal {

    /**
     * Root -> leftSubtree -> rightSubtree
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            helper(root.left, res);
            helper(root.right, res);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode treeNode = BinaryTree.buildTree(nodes);
        System.out.println(preorderTraversal(treeNode));

    }
}
