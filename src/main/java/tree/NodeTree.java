package tree;

import java.util.List;

public class NodeTree {
    public int val;
    public List<NodeTree> children;

    public NodeTree() {}

    public NodeTree(int _val) {
        val = _val;
    }

    public NodeTree(int _val, List<NodeTree> _children) {
        val = _val;
        children = _children;
    }
}
