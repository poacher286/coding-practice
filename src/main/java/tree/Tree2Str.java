package tree;

public class Tree2Str {
    public String tree2str(TreeNode root) {
        if (root == null){
            return "";
        }

        String result = root.val + "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (root.left == null && root.right == null){
            return result;
        }

        if (root.left == null){
            return result + "()" + "(" + right + ")";
        }

        if (root.right == null){
            return result + "(" + left + ")";
        }

        return result + "(" + left + ")" + "(" + right + ")";
    }
}
