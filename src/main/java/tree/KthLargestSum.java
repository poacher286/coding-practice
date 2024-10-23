package tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargestSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<List<Long>> res = new LinkedList<>();
        bfs(root, res, 0);
        List<Long> lis = res.stream()
                .map(x -> x.stream().mapToLong(l -> l).sum())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return lis.size() >= k ? lis.get(k - 1) : -1;
    }

    public static void bfs(TreeNode root, List<List<Long>> res, int level){
        if (root == null){
            return;
        }
        if (level >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(level).add((long) root.val);
        bfs(root.left, res, level + 1);
        bfs(root.right, res, level + 1);
    }
}
