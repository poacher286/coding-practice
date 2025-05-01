package strings;

public class CheckValidParanthesis {
    /**
     * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
     *
     * The following rules define a valid string:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "(*)"
     * Output: true
     * Example 3:
     *
     * Input: s = "(*))"
     * Output: true
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        int left = 0;
        int right = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                left++;
                right++;
            }else if(c == ')'){
                left--;
                right--;
            }else{
                left--;
                right++;
            }

            if (right < 0) {
                return false;
            }

            left = Math.min(0, left);
        }

        return left == 0;
    }
}
