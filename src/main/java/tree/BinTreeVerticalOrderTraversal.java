package tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinTreeVerticalOrderTraversal {
    /**
     * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
     * <p>
     * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
     * <p>
     * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
     * <p>
     * Return the vertical order traversal of the binary tree.
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        //bfs travel
        //use queue to store value and col idx
        //remove from queue and add in map
        //iterate from min and max and add in ans
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int col = 0;
        int min = 0;
        int max = 0;
        queue.offer(new AbstractMap.SimpleEntry<>(root, col));

        while (!queue.isEmpty()) {

            Map.Entry<TreeNode, Integer> curr = queue.poll();
            root = curr.getKey();
            col = curr.getValue();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(root.val);
            min = Math.min(min, col);
            max = Math.max(max, col);
            if (root.left != null) queue.offer(new AbstractMap.SimpleEntry<>(root.left, col - 1));
            if (root.right != null) queue.offer(new AbstractMap.SimpleEntry<>(root.right, col + 1));
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Tree Structure:");
        TreeNode.printTree(root, 0);

        System.out.println(verticalTraversal(root));
    }

}
