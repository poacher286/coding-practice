package twoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82 --> square
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: false
 */
public class HappyNumber {
    public static Map<Integer, Integer> happyMap = new HashMap<>();

    public static boolean isHappy(int n) {
        int temp = n;
        int sum = 0;
        int rem;
        while (temp > 0) {
            rem = temp % 10;
            sum += rem * rem;
            temp = temp / 10;
        }

        if (happyMap.containsValue(sum)) {
            return false;
        } else if (sum == 1) {
            return true;
        } else {
            happyMap.put(n, sum);
            return isHappy(happyMap.get(n));
        }
    }

    public static void main(String[] args) {
        int testNumber = 13;
        System.out.println("Happy Number : " + testNumber + " : " + isHappy(testNumber));
    }
}
