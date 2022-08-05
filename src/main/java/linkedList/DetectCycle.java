package linkedList;

public class DetectCycle {
    /**
     * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
     *
     * Algo - slow and fast will definetly meet at some point if it has cycle
     * they will meet k step ahead from intersection point
     * so we again start fast/slow from head and move 1 step so that they will meet at intersection point
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)break;//they meet
        }

        if(fast != slow)return null;

        slow = head;//reinitialize from start

        while(slow != fast){//they will meet at intersection point
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
