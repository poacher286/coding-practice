package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()){
            int levelSize = treeNodeQueue.size();

            double currLevelAvg = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = treeNodeQueue.poll();
                currLevelAvg += currNode.val;
                if (currNode.left != null){
                    treeNodeQueue.offer(currNode.left);
                }
                if (currNode.right != null){
                    treeNodeQueue.offer(currNode.right);
                }
            }
            currLevelAvg = currLevelAvg / levelSize;
            res.add(currLevelAvg);
        }

        return res;
    }
}
