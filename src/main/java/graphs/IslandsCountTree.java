package graphs;

import tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class IslandsCountTree {
    /**
     * count island in tree having 0 and 1
     *     1
     *    / \
     *   1   0
     *  /     \
     * 1       1
     *
     * There are two islands of 1s:
     * - Left side: 1 → 1 → 1
     * - Right side: single 1
     * Output: 2
     */
    public static int islandCount(TreeNode root){
        Set<TreeNode> visited = new HashSet<>();
        return dfsIslandCount(root, visited);
    }

    private static int dfsIslandCount(TreeNode root, Set<TreeNode> visited) {
        if (root == null) return 0;
        int count = 0;
        if (root.val == 1 && !visited.contains(root)){
            count++;
            exploreLand(root, visited);
        }

        count += dfsIslandCount(root.left, visited);
        count += dfsIslandCount(root.right, visited);

        return count;
    }

    private static void exploreLand(TreeNode root, Set<TreeNode> visited) {
        if (root == null || root.val == 0 || visited.contains(root)) return;

        visited.add(root);

        exploreLand(root.left, visited);
        exploreLand(root.right, visited);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(1);

        System.out.println("Tree Structure:");
        printTree(root, 0);

        int result = islandCount(root);
        System.out.println("Number of islands of 1s: " + result);
    }

    private static void printTree(TreeNode node, int level) {
        if (node == null) return;

        printTree(node.right, level + 1);

        System.out.println("    ".repeat(level) + node.val);

        printTree(node.left, level + 1);
    }

}
