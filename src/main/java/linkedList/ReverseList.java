package linkedList;

public class ReverseList {
    /**
     * iterate through list
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head !=null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;

    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        return prev;
    }
}
