package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MinAbsDifference {
    /**
     * Given the root of a Binary Search Tree (BST),
     * return the minimum absolute difference between the values of any two different nodes in the tree.
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < vals.size() - 1; i++) {
            minDiff = Math.min(minDiff, vals.get(i + 1) - vals.get(i));
        }
        return minDiff;
    }

    //left -> root -> right
    public void inorder(TreeNode root, List<Integer> vals){
        if (root == null){
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
