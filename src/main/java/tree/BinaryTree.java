package tree;

public class BinaryTree {
    static int idx = -1;
    public static TreeNode buildTree(int[] nodes){
        idx++;
        if (nodes[idx] == -1){
            return null;
        }

        TreeNode myNode = new TreeNode(nodes[idx]);
        myNode.left = buildTree(nodes);
        myNode.right = buildTree(nodes);

        return myNode;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode treeNode = buildTree(nodes);
        System.out.println(treeNode.val);

    }
}
