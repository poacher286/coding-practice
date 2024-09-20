package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        targetSum = targetSum - root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allFoundList = new ArrayList<>();
        List<Integer> foundList = new ArrayList<>();
        if (root == null) {
            return allFoundList;
        }
        dfs(root, targetSum, allFoundList, foundList);
        return allFoundList;
    }

    public void dfs(TreeNode root, int target, List<List<Integer>> allFoundList, List<Integer> foundList){
        if (root == null) {
            return;
        }

        foundList.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            allFoundList.add(new ArrayList<>(foundList));
        }
        target = target - root.val;
        dfs(root.left, target, allFoundList, foundList);
        dfs(root.right, target, allFoundList, foundList);
        foundList.remove(foundList.size() - 1);
    }
}
