package strings;

import java.util.Stack;

public class BalancedStringSplit {
    /**
     * Input: s = "RLRRLLRLRL"
     * Output: 4
     * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'
     * @param s
     * @return
     */
    public static int balancedStringSplit(String s) {
        int c = 0;
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if((!stack.isEmpty()) && ((ch == 'L' && stack.peek()=='R') || (ch == 'R' && stack.peek() == 'L')))
                stack.pop();
            else
                stack.push(ch);
            if(stack.isEmpty())
                c++;
        }
        return c;

    }
}
