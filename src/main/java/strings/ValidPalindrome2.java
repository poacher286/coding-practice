package strings;

public class ValidPalindrome2 {
    /**
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aba"
     * Output: true
     * Example 2:
     *
     * Input: s = "abca"
     * Output: true
     * Explanation: You could delete the character 'c'.
     * Example 3:
     *
     * Input: s = "abc"
     * Output: false
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        //[abcdceba]
        //
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindromeWithInRange(s, left + 1, right) || isPalindromeWithInRange(s, left, right - 1);
            }
        }
        return true;
    }

    public static boolean isPalindromeWithInRange(String str, int left, int right){
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
