package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestNumber {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        return values.get(k - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> values) {
        if (root == null){
            return;
        }
        //Inorder = Left -> root -> right
        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }
}
