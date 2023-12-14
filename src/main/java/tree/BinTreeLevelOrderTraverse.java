package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinTreeLevelOrderTraverse {
    /**
     * BFS - bredth first search
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int level){
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        helper(root.left , res, level+1);
        helper(root.right , res, level+1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()){
            int levelSize = treeNodeQueue.size();

            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = treeNodeQueue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null){
                    treeNodeQueue.offer(currNode.left);
                }
                if (currNode.right != null){
                    treeNodeQueue.offer(currNode.right);
                }
            }
            res.add(currLevel);
        }

        return res;
    }
}
