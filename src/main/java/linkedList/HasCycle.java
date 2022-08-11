package linkedList;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer)
                return true;
        }
        return false;
    }
}
