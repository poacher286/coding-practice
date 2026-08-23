package linkedList;

public class LengthOfCycle {
    public int lengthOfCycleInLL(ListNode head) {
        if (head == null || head.next == null) return -1;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                //found the intersection
                //pause fast pointer and move slow pointer
                int length = 0;
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                return length;
            }
        }
        return -1;
    }
}
