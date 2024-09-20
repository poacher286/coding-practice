package stacks;

import java.util.Stack;

public class ReverseSubstringBetweenBracket {
    /**
     * You are given a string s that consists of lower case English letters and brackets.
     *
     * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
     *
     * Your result should not contain any brackets.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "(abcd)"
     * Output: "dcba"
     * Example 2:
     *
     * Input: s = "(u(love)i)"
     * Output: "iloveu"
     * Explanation: The substring "love" is reversed first, then the whole string is reversed.
     * Example 3:
     *
     * Input: s = "(ed(et(oc))el)"
     * Output: "leetcode"
     * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
     * @param s
     * @return
     */
    public static String reverseParentheses(String s) {
        //(ed(et(oc))el)
        // stack - (ed(et(oc ==> if char == ')' then pop untill '('
        // (ed(et( --> append in ans = "co"
        //(ed(etco)el)
        // repeat ==> (edocteel) ==> leetcode
        Stack<Integer> characterStack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == ')'){
                //pop till '('
                ans.setLength(0);
                do{
                    ans.append((char) characterStack.pop().intValue());
                }while (characterStack.peek() != '(');
                characterStack.pop();
                ans.chars().boxed().forEach(characterStack::push);
            }else{
                characterStack.push((int) c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
//        String s = "(ed(et(oc))el)";
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}
