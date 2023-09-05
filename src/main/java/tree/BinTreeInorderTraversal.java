package tree;

import java.util.ArrayList;
import java.util.List;

public class BinTreeInorderTraversal {
    /**
     * leftsubtree -> root -> right subtree
     * @param node
     * @return
     */
    static List<Integer> traveller = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }

        inorderTraversal(root.left);
        traveller.add(root.val);
        inorderTraversal(root.right);
        return traveller;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode treeNode = BinaryTree.buildTree(nodes);
        System.out.println(inorderTraversal(treeNode));

    }

}
