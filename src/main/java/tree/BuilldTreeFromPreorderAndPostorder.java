package tree;

import java.util.Arrays;

public class BuilldTreeFromPreorderAndPostorder {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0 || postorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        // Base case: only one node
        if (preorder.length == 1) return root;

        // preorder[1] is always the root of the left subtree
        int leftRootVal = preorder[1];

        // Find the leftRootVal in postorder to determine the left subtree size
        int L = 0;
        while (postorder[L] != leftRootVal) L++;
        L++; // Include the root of the left subtree

        // Slice arrays for left and right subtrees
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + L);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + L, preorder.length);

        int[] postLeft = Arrays.copyOfRange(postorder, 0, L);
        int[] postRight = Arrays.copyOfRange(postorder, L, postorder.length - 1);

        root.left = constructFromPrePost(preLeft, postLeft);
        root.right = constructFromPrePost(preRight, postRight);

        return root;
    }
}
