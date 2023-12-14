package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean reverse = false;
        while (!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (!reverse){
                    //remove from first and add in last
                    TreeNode currNode = deque.pollFirst();
                    currLevel.add(currNode.val);
                    if (currNode.left != null){
                        deque.addLast(currNode.left);
                    }
                    if (currNode.right != null){
                        deque.addLast(currNode.right);
                    }
                }else{
                    //remove from last and add in first
                    TreeNode currNode = deque.pollLast();
                    currLevel.add(currNode.val);
                    if (currNode.right != null){
                        deque.addFirst(currNode.right);
                    }
                    if (currNode.left != null){
                        deque.addFirst(currNode.left);
                    }
                }
            }
            reverse = !reverse;
            res.add(currLevel);
        }
        return res;
    }

}
