package strings;

import java.util.Stack;

public class MinLengthAfterRemovingABCD {

    /**
     * You are given a string s consisting only of uppercase English letters.
     *
     * You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.
     *
     * Return the minimum possible length of the resulting string that you can obtain.
     *
     * Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "ABFCACDB"
     * Output: 2
     * Explanation: We can do the following operations:
     * - Remove the substring "ABFCACDB", so s = "FCACDB".
     * - Remove the substring "FCACDB", so s = "FCAB".
     * - Remove the substring "FCAB", so s = "FC".
     * So the resulting length of the string is 2.
     * It can be shown that it is the minimum length that we can obtain.
     * @param s
     * @return
     */
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                s = s.replace("AB", "");
            } else if (s.contains("CD")) {
                s = s.replace("CD", "");
            }
        }
        return s.length();
    }

    public int minLengthStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else if (c == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}
