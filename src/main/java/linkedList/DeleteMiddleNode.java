package linkedList;

public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow now become middle
        //delete slow node

        //point slow node to next node
        slow.next = slow.next.next;

        return head;
    }
}
