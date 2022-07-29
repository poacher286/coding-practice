package strings;

import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                boolean val = handleClosing(st, '(');
                if (!val) {
                    return false;
                }
            } else if (ch == '}') {
                boolean val = handleClosing(st, '{');
                if (!val) {
                    return false;
                }
            } else if (ch == ']') {
                boolean val = handleClosing(st, '[');
                if (!val) {
                    return false;
                }
            }

        }
        return st.size() == 0;
    }

    public static boolean handleClosing(Stack<Character> st, char someBracket) {

        if (st.size() == 0) {
            return false;
        } else if (st.peek() != someBracket) {
            return false;
        } else {
            st.pop();
            return true;
        }
    }
}
