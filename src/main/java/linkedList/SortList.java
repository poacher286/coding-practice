package linkedList;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = midNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode temp_node = new ListNode(0);// temp_node = 0->null
        ListNode current_node = temp_node;//current_node = 0->null
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current_node.next = list1;
                list1 = list1.next;
            } else {
                current_node.next = list2;
                list2 = list2.next;
            }
            current_node = current_node.next;
        }
        if (list1 != null) {
            current_node.next = list1;
        }
        if (list2 != null) {
            current_node.next = list2;
        }

        return temp_node.next;
    }

    public static ListNode midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
}
