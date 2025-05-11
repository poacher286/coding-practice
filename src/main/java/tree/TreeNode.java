package tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printTree(TreeNode node, int level) {
        if (node == null) return;

        printTree(node.right, level + 1);

        System.out.println("    ".repeat(level) + node.val);

        printTree(node.left, level + 1);
    }
}