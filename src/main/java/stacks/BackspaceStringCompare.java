package stacks;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 */
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(!s1.isEmpty())
                    s1.pop();
                continue;
            }
            s1.push(ch);
        }

        for(char ch : t.toCharArray()){
            if(ch == '#'){
                if(!s2.isEmpty())
                    s2.pop();
                continue;
            }
            s2.push(ch);
        }

        String res1 = "";
        String res2 = "";

        while(!s1.isEmpty())
            res1 += s1.pop();

        while(!s2.isEmpty())
            res2 += s2.pop();

        return res1.equals(res2);
    }

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }
}
