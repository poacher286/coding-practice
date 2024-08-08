package stacks;

import java.util.Stack;

public class MaxNestingDepth {
    /**
     * Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "(1+(2*3)+((8)/4))+1"
     *
     * Output: 3
     *
     * Explanation:
     *
     * Digit 8 is inside of 3 nested parentheses in the string.
     *
     * Example 2:
     *
     * Input: s = "(1)+((2))+(((3)))"
     *
     * Output: 3
     *
     * Explanation:
     *
     * Digit 3 is inside of 3 nested parentheses in the string.
     *
     * Example 3:
     *
     * Input: s = "()(())((()()))"
     *
     * Output: 3
     * @param s
     * @return
     */
    public static int maxDepth(String s) {
        Stack<Character> stChars = new Stack<>();
        int maxStackDepth = 0;
        for (char c : s.toCharArray()){
            if (c == '('){
                stChars.push(c);
            }else if(c == ')'){
                maxStackDepth = Math.max(maxStackDepth, stChars.size());
                stChars.pop();
            }
        }
        return maxStackDepth;
    }

    public static void main(String[] args) {
        String s = "()(())((()()))";
        System.out.println(maxDepth(s));
    }
}
