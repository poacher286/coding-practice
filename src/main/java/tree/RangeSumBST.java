package tree;

public class RangeSumBST {
    /**
     * Given the root node of a binary search tree and two integers low and high,
     * return the sum of values of all nodes with a value in the inclusive range [low, high].
     * @param root
     * @param low
     * @param high
     * @return
     */
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }

        if(root.val >= low && root.val <= high){
            sum += root.val;
        }

        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);

        return sum;
    }
}
