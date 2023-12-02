package linkedList;

/**
 * Given the head of a linked list head, in which each node contains an integer value.
 *
 * Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
 *
 * Return the linked list after insertion.
 *
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 *
 * Input: head = [18,6,10,3]
 * Output: [18,6,6,2,10,1,3]
 */
public class InsertGCD {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null){
            //gcd -> slow.val , fast.val
            int gcd = gcd(slow.val, fast.val);

            //insert gcd -> slow and fast
            ListNode gcdNode = new ListNode(gcd);
            slow.next = gcdNode;
            gcdNode.next = fast;
            slow = fast;

            //update fast = fast.next
            fast = fast.next;
        }
        return head;
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
