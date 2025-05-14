package tree;

import java.util.Arrays;

public class BuildTreeFromInorderAndPostorder {
    /**
     * Given two integer arrays inorder and postorder
     * where inorder is the inorder traversal of a binary tree and
     * postorder is the postorder traversal of the same tree, construct and return the binary tree.
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        //postorder
        //left - right - root
        //inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        int mid = findIndex(inorder, val);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, mid), Arrays.copyOfRange(postorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(inorder, mid + 1, inorder.length), Arrays.copyOfRange(postorder, mid, postorder.length - 1));

        return root;
    }

    private int findIndex(int[] inorder, int tar) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == tar) return i;
        }
        return -1;
    }
}
