package slidingWindow;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 */
public class NoOfSubStringContainingAll3Character {
    public static int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        int[] count = {0, 0, 0};
        int ans = 0;
        for (; right < s.length(); right++){
            count[s.charAt(right) - 'a']++;
            for (; count[0] > 0 && count[1] > 0 && count[2] > 0; left++){
                count[s.charAt(left) - 'a']--;
            }
            ans += left;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
