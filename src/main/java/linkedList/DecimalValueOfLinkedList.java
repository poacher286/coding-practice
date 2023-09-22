package linkedList;

public class DecimalValueOfLinkedList {
    public int getDecimalValue(ListNode head) {
        String ans = "";
        while (head != null) {
            ans += head.val;
            head = head.next;
        }

        return Integer.parseInt(ans, 2);
    }

    /**
     * Head = 1 -> 0 -> 1
     * 1)
     * ans = 0 + 1 = 1
     *
     * 2)
     * ans = 10 + 0 = 10
     *
     * 3)
     * ans = 100 + 1 = 101
     * @param head
     * @return
     */
    public int getDecimalValue2(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) + head.val;
            head = head.next;
        }
        return ans;
    }
}
