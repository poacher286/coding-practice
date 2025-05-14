package tree;

import java.util.Arrays;

public class BuildTreeFromInorderAndPreorder {
    /**
     * Given two integer arrays preorder and inorder
     * where preorder is the preorder traversal of a binary tree and
     * inorder is the inorder traversal of the same tree, construct and return the binary tree.
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        TreeNode root = new TreeNode(preorder[0]);
        int mid = findIndex(inorder, preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));

        return root;
    }

    private int findIndex(int[] inorder, int tar) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == tar) return i;
        }
        return -1;
    }
}
