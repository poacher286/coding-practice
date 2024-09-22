package tree;

import java.util.LinkedList;
import java.util.List;

public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode();
        if (root == null) {
            return ans;
        }
        List<Integer> vals = new LinkedList<>();
        inorder(root, vals);
        for (int val : vals) {
            ans.right.val = val;
        }
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
