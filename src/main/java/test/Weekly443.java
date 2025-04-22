package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Weekly443 {
    /**
     * You are given an integer array cost of size n. You are currently at position n (at the end of the line) in a line of n + 1 people (numbered from 0 to n).
     *
     * You wish to move forward in the line, but each person in front of you charges a specific amount to swap places. The cost to swap with person i is given by cost[i].
     *
     * You are allowed to swap places with people as follows:
     *
     * If they are in front of you, you must pay them cost[i] to swap with them.
     * If they are behind you, they can swap with you for free.
     * Return an array answer of size n, where answer[i] is the minimum total cost to reach each position i in the line.
     *
     *  
     *
     * Example 1:
     *
     * Input: cost = [5,3,4,1,3,2]
     *
     * Output: [5,3,3,1,1,1]
     *
     * Explanation:
     *
     * We can get to each position in the following way:
     *
     * i = 0. We can swap with person 0 for a cost of 5.
     * i = 1. We can swap with person 1 for a cost of 3.
     * i = 2. We can swap with person 1 for a cost of 3, then swap with person 2 for free.
     * i = 3. We can swap with person 3 for a cost of 1.
     * i = 4. We can swap with person 3 for a cost of 1, then swap with person 4 for free.
     * i = 5. We can swap with person 3 for a cost of 1, then swap with person 5 for free.
     * @param cost
     * @return
     */
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && cost[deque.peekLast()] > cost[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            answer[i] = cost[deque.peekFirst()];
        }

        return answer;
    }


    public int longestPalindrome(String s, String t) {
        int maxLen = 0;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String subS = s.substring(i, j);

                for (int x = 0; x <= t.length(); x++) {
                    for (int y = x; y <= t.length(); y++) {
                        String subT = t.substring(x, y);
                        String combined = subS + subT;

                        if (isPalindrome(combined)) {
                            maxLen = Math.max(maxLen, combined.length());
                        }
                    }
                }
            }
        }

        return maxLen;
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
