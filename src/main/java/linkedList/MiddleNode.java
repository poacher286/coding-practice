package linkedList;

public class MiddleNode {
    /**
     * increase slow 1 and fast 2
     * when fast finishes return slow
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
