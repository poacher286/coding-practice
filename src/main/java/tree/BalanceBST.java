package tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    /**
     * Given the root of a binary search tree,
     * return a balanced binary search tree with the same node values.
     * If there is more than one answer, return any of them.
     *
     * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        inorderBST(root, sorted);
        return buildBSTFromSorted(sorted, 0, sorted.size() - 1);
    }

    private TreeNode buildBSTFromSorted(List<Integer> sorted, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sorted.get(mid));
        root.left = buildBSTFromSorted(sorted, start, mid - 1);
        root.right = buildBSTFromSorted(sorted, mid + 1, end);
        return root;
    }

    private void inorderBST(TreeNode root, List<Integer> sorted) {
        if (root != null) {
            inorderBST(root.left, sorted);
            sorted.add(root.val);
            inorderBST(root.right, sorted);
        }
    }
}
