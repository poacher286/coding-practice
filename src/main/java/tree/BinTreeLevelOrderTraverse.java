package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
            res.add(new LinkedList<Integer>());
        }
        res.get(level).add(root.val);
        helper(root.left , res, level+1);
        helper(root.right , res, level+1);
    }
}
