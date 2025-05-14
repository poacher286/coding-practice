package tree;

public class BuildBSTFromPostorder {
    public static TreeNode bstFromPost(int[] postorder){
        if (postorder.length == 0) return null;

        //postorder = [2, 4, 3, 8, 7, 5]
        int idx = postorder.length - 1;
        return buildTreeUtil(postorder, idx, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode buildTreeUtil(int[] postorder, int idx, int minValue, int maxValue) {
        if (idx < 0) return null;

        int val = postorder[idx];
        if (val < minValue || val > maxValue) return null;

        TreeNode root = new TreeNode(val);
        idx--;

        root.left = buildTreeUtil(postorder, idx, minValue, val);
        root.right = buildTreeUtil(postorder, idx, val, maxValue);

        return root;
    }
}
