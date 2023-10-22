package stacks;

import java.util.Stack;

/**
 * You are given a string s, which contains stars *.
 *
 * In one operation, you can:
 *
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 *
 * Note:
 *
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 *
 *
 * Example 1:
 *
 * Input: s = "leet**cod*e"
 * Output: "lecoe"
 */
public class RemoveStarFromString {
    public static String removeStars(String s) {
        Stack<Character> s1 = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(!s1.isEmpty())
                    s1.pop();
                continue;
            }
            s1.push(ch);
        }
        StringBuilder res = new StringBuilder();

        while(!s1.isEmpty()) {
            res.append(s1.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }
}
