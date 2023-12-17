package tree;

public class PopulateNextRightPointer {
    public Node connect(Node root) {
        if (root == null) return null;

        Node levelStart = root;

        while (levelStart != null) {
            Node current = levelStart;

            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }

                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            levelStart = levelStart.left;
        }

        return root;
    }
}
