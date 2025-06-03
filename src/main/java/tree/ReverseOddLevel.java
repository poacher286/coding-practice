package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevel {
    /**
     * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
     *
     * For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
     * Return the root of the reversed tree.
     *
     * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
     *
     * The level of a node is the number of edges along the path between it and the root node.
     * @param root
     * @return
     */
    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            TreeNode[] arrTreeLevel = new TreeNode[size];
            for (int i = 0; i < size; i++) {
                arrTreeLevel[i] = queue.poll();
                if (arrTreeLevel[i].left != null) queue.offer(arrTreeLevel[i].left);
                if (arrTreeLevel[i].right != null) queue.offer(arrTreeLevel[i].right);
            }

            if (level % 2 != 0) reverseValues(arrTreeLevel);

            level++;
        }
        return root;
    }

    private void reverseValues(TreeNode[] arrTreeLevel) {
        int left = 0;
        int right = arrTreeLevel.length - 1;
        while (left < right) {
            int temp = arrTreeLevel[left].val;
            arrTreeLevel[left++].val = arrTreeLevel[right].val;
            arrTreeLevel[right--].val = temp;
        }
    }

    public TreeNode reverseOddLevelsDFS(TreeNode root) {
        dfs(root.left, root.right, 1);//level is initialize by 1 as we already moved to first level root.left & root.right
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) return;

        if (level % 2 != 0) {
            //swap values
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
    }
}
