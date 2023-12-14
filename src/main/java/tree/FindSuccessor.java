package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindSuccessor {
    public TreeNode averageOfLevels(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()){
            TreeNode currNode = treeNodeQueue.poll();
            if (currNode.left != null){
                treeNodeQueue.offer(currNode.left);
            }
            if (currNode.right != null){
                treeNodeQueue.offer(currNode.right);
            }
            if (currNode.val == key){
                break;
            }
        }

        return treeNodeQueue.peek();
    }
}
