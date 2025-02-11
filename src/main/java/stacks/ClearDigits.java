package stacks;

import java.util.Stack;

public class ClearDigits {
    /**
     * You are given a string s.
     *
     * Your task is to remove all digits by doing this operation repeatedly:
     *
     * Delete the first digit and the closest non-digit character to its left.
     * Return the resulting string after removing all digits.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abc"
     *
     * Output: "abc"
     *
     * Explanation:
     *
     * There is no digit in the string.
     *
     * Example 2:
     *
     * Input: s = "cb34"
     *
     * Output: ""
     *
     * Explanation:
     *
     * First, we apply the operation on s[2], and s becomes "c4".
     *
     * Then we apply the operation on s[1], and s becomes "".
     * @param s
     * @return
     */
    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch) && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(clearDigits(s));
    }
}
