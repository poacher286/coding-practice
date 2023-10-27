package strings;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        int[] r = {0, 1};
        for (int i = 0; i < s.length(); i++) {
            extend(s, i - 1, i + 1, r);
            extend(s, i - 1, i, r);
        }
        return s.substring(r[0], r[1]);
    }

    private static void extend(String s, int lo, int hi, int[] r){
        while (0 <= lo && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        if(hi - lo - 1 > r[1] - r[0]){
            r[0] = lo + 1;
            r[1] = hi;
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
