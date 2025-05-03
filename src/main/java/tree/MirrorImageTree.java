package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorImageTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null){
                continue;
            }

            if (left == null || right == null){
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            //left.left
            //right.right
            //left.right
            //right.left
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return isSym(root, root);
    }

    public boolean isSym(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null) return false;
        if (root2 == null) return false;
        if (root1.val != root2.val) return false;

        return isSym(root1.left, root2.right) && isSym(root1.right, root2.left);
    }
}
