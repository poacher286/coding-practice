package tree;

import java.util.ArrayList;
import java.util.List;

public class BinTreePreorderTraversal {

    /**
     * Root -> leftSubtree -> rightSubtree
     * @param root
     * @return
     */
    static List<Integer> traveller = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        traveller.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return traveller;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode treeNode = BinaryTree.buildTree(nodes);
        System.out.println(preorderTraversal(treeNode));

    }
}
