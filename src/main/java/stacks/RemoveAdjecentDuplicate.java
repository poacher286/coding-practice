package stacks;

import java.util.Stack;

public class RemoveAdjecentDuplicate {
    /**
     * You are given a string s consisting of lowercase English letters.
     * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
     *
     * We repeatedly make duplicate removals on s until we no longer can.
     *
     * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abbaca"
     * Output: "ca"
     * Explanation:
     * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
     * and this is the only possible move.  The result of this move is that the string is "aaca",
     * of which only "aa" is possible, so the final string is "ca".
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0;) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)){
                i--;
                stack.pop();
            }else {
                stack.push(s.charAt(i--));
            }
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }


    public static String removeKAdjecentDuplicates(String s, int k) {
        Stack<Character> stackChar = new Stack<>();
        Stack<Integer> stackCount = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (stackChar.isEmpty()) {//if empty the push in stack
                stackChar.push(s.charAt(i));
                stackCount.push(1);
            }else {
                if (stackChar.peek() == s.charAt(i)) {
                    //add char in stack
                    stackChar.push(s.charAt(i));
                    stackCount.push(stackCount.peek() + 1);
                    if (stackCount.peek() == k){
                        for (int j = 0; j < k; j++) {
                            stackChar.pop();
                            stackCount.pop();
                        }
                    }
                }else{//if character is different push in stack
                    stackChar.push(s.charAt(i));
                    stackCount.push(1);
                }
            }
        }

        String ans = "";
        while (!stackChar.isEmpty()) {
            ans = stackChar.pop() + ans;
        }

        return ans;
    }

    public static void main(String[] args) {
//        String s = "abbaca";
//        String s = "azxxzy";
//        System.out.println(removeDuplicates(s));
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeKAdjecentDuplicates(s, k));
    }
}
