package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinTreeInorderTraversal {
    /**
     * leftsubtree -> root -> right subtree
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

    public static List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()){
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode treeNode = BinaryTree.buildTree(nodes);
        System.out.println(inorderTraversal(treeNode));
        System.out.println(inorderTraversalStack(treeNode));

    }

}
