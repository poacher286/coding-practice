package twoPointers;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = inOrderTraversal(root, new ArrayList<>());
        int leftPointer = 0;
        int rightPointer = list.size() - 1;
        while (leftPointer < rightPointer){
            if (list.get(leftPointer) + list.get(rightPointer) == k) return true;
            else if (list.get(leftPointer) + list.get(rightPointer) < k) leftPointer++;
            else rightPointer--;
        }
        return false;
    }

    public List<Integer> inOrderTraversal(TreeNode root, List<Integer> helper) {
        if (root == null) return null;
        inOrderTraversal(root.left , helper);
        helper.add(root.val);
        inOrderTraversal(root.right , helper);
        return helper;
    }
}
