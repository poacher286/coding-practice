package numbers;

/**
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 *
 * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = "32"
 * Output: 3
 * Explanation: 10 + 11 + 11 = 32
 *
 * Approach:
 * 1. We need 9 ones to make 9
 *  - we need 9 numbers
 *  - all other numbers need less than 9 ones
 *  so we need largest number in string
 */
public class DeciBinaryNumber {

    public int minPartitions(String n) {
        int max = 0;
        for (int i=0; i<n.length(); i++) {
            if (n.charAt(i) - '0' == 9) return 9;
            max = Math.max(max, (n.charAt(i) - '0'));
        }
        return max;
    }
}
