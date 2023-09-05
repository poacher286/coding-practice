package tree;

import java.util.ArrayList;
import java.util.List;

public class BinTreePostorderTraversal {
    /**
     * leftsubtree -> right subtree -> root
     * @param node
     * @return
     */
    static List<Integer> traveller = new ArrayList<>();
    public static List<Integer> postOrderTraversal(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        traveller.add(root.val);
        return traveller;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode treeNode = BinaryTree.buildTree(nodes);
        System.out.println(postOrderTraversal(treeNode));

    }

}
