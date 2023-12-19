package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                TreeNode currNode = queue.poll();

                if (i == levelSize - 1){
                    result.add(currNode.val);
                }
                if (currNode.left != null){
                    queue.offer(currNode.left);
                }
                if (currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
        }
        return result;
    }
}
