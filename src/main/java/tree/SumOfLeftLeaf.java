package tree;

public class SumOfLeftLeaf {
    /**
     * Given the root of a binary tree, return the sum of all left leaves.
     *
     * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 24
     * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
     * Example 2:
     *
     * Input: root = [1]
     * Output: 0
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }

        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
