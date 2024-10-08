package tree;

import java.util.List;

public class MaxDepthNArrayTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int maxD = 0;
        for (Node child : root.children){
            maxD = Math.max(maxD, maxDepth(child));
        }
        return maxD + 1;
    }
}


