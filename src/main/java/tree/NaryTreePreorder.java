package tree;


import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorder {
    /**
     * DFS depth first search
     * @param root
     * @return
     */
    public List<Integer> preorder(NodeTree root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    private void helper(NodeTree root, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);

        for(NodeTree child : root.children) {
            helper(child, list);
        }
    }
}
