package tree;

import java.util.HashSet;
import java.util.Set;

public class UniTree {
    /**
     * A binary tree is uni-valued if every node in the tree has the same value.
     *
     * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        isUni(root, set);
        return set.size() == 1;
    }

    public void isUni(TreeNode root, Set<Integer> set){
        if(root != null) {
            //left -> root -> right
            isUni(root.left, set);
            set.add(root.val);
            isUni(root.right, set);
        }
    }
}
