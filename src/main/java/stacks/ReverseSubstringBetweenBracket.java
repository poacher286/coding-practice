package stacks;

import java.util.Stack;

public class ReverseSubstringBetweenBracket {
    /**
     * You are given a string s that consists of lower case English letters and brackets.
     * <p>
     * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
     * <p>
     * Your result should not contain any brackets.
     * <p>
     *
     *
     * Example 1:
     * <p>
     * Input: s = "(abcd)"
     * Output: "dcba"
     * Example 2:
     * <p>
     * Input: s = "(u(love)i)"
     * Output: "iloveu"
     * Explanation: The substring "love" is reversed first, then the whole string is reversed.
     * Example 3:
     * <p>
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
        Stack<Character> characterStack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == ')'){
                //pop till '('
                ans.setLength(0);//reset length

                while (characterStack.peek() != '('){
                    ans.append((char) characterStack.pop());
                }

                characterStack.pop();
                ans.chars().boxed().forEach(x -> characterStack.push((char) x.intValue()));
            }else{
                characterStack.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!characterStack.isEmpty()) {
            res.append(characterStack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
//        String s = "(ed(et(oc))el)";
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}
