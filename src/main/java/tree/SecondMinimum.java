package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondMinimum {
    /**
     * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
     *
     * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
     *
     * If no such second minimum value exists, output -1 instead.
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        Collections.sort(vals);
        int min = vals.get(0);
        for(int val : vals){
            if(val > min){
                return val;
            }
        }
        return -1;
    }

    public void inorder(TreeNode root, List<Integer> vals){
        if(root == null){
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
