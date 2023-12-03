package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the head of a sorted linked list,
 * delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null){
            if (slow.val == fast.val) {//check consecutive element
                //delete node
                slow.next = fast.next;
            }else{
                slow = fast;
            }

            //update fast
            fast = fast.next;
        }
        return head;
    }
}
