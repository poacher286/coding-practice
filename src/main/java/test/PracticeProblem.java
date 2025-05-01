package test;

import java.util.Stack;

public class PracticeProblem {
    /**
     * Write a function that takes a string of parentheses,
     * and determines if the order of the parentheses is valid.
     * The function should return true if the string is valid, and false if it's invalid.
     *
     * Examples
     * "()"              =>  true
     * ")(()))"          =>  false
     * "("               =>  false
     * "(())((()())())"  =>  true
     */
    public static boolean validParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                //push to stack
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean validParenthesis2(String str) {
        int balance = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                if (--balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        System.out.println(validParenthesis("()"));
        System.out.println(validParenthesis(")(()))"));
        System.out.println(validParenthesis("("));
        System.out.println(validParenthesis("(())((()())())"));
        System.out.println(validParenthesis2("()"));
        System.out.println(validParenthesis2(")(()))"));
        System.out.println(validParenthesis2("("));
        System.out.println(validParenthesis2("(())((()())())"));
    }
}
