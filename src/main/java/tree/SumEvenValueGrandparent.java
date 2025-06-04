package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumEvenValueGrandparent {
    /**
     * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent.
     * If there are no nodes with an even-valued grandparent, return 0.
     *
     * A grandparent of a node is the parent of its parent if it exists.
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int sum = 0;
        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();
            if (curr.val % 2 == 0){
                if (curr.left != null) sum += findVal(curr.left.left) + findVal(curr.left.right);
                if (curr.right != null) sum += findVal(curr.right.left) + findVal(curr.right.right);
            }

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }

        return sum;
    }

    private int findVal(TreeNode root) {
        return root == null ? 0 : root.val;
    }

    public int sumEvenGrandparent2(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if((root.val & 1) == 0){
            if(root.left != null && root.left.left != null) sum += root.left.left.val;
            if(root.left != null && root.left.right != null) sum += root.left.right.val;
            if(root.right != null && root.right.left != null) sum += root.right.left.val;
            if(root.right != null && root.right.right != null) sum += root.right.right.val;
        }

        return sum + sumEvenGrandparent2(root.left) + sumEvenGrandparent2(root.right);
    }

    public int sumEvenGrandparent3(TreeNode root) {
        return dfs(root, null, null); //Perform DFS
    }

    private int dfs(TreeNode current, TreeNode parent, TreeNode grandParent) {
        int sum = 0;
        if (current == null) return 0;
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += current.val;
        }
        sum += dfs(current.left, current, parent);
        sum += dfs(current.right, current, parent);
        return sum;
    }
}
