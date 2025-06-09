package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC_1261 {

    class FindElements {
        private Set<Integer> set;

        public FindElements(TreeNode root) {
            set = new HashSet<>();
//            bfs(root);
            dfs(root, 0);
        }

        public boolean find(int target) {
            return set.contains(target);
        }


        private void bfs(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            root.val = 0;
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                set.add(curr.val);
                if (curr.left != null) {
                    curr.left.val = curr.val * 2 + 1;
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = curr.val * 2 + 2;
                    queue.offer(curr.right);
                }
            }
        }

        private void dfs(TreeNode currNode, int currValue) {
            if (currNode == null) return;

            set.add(currValue);

            dfs(currNode.left, currValue * 2 + 1);
            dfs(currNode.right, currValue * 2 + 2);
        }
    }
}
