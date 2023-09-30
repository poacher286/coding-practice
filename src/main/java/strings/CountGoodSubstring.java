package strings;

/**
 * A string is good if there are no repeated characters.
 *
 * Given a string s, return the number of good substrings of length three in s.
 *
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 *
 * A substring is a contiguous sequence of characters in a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "xyzzaz"
 * Output: 1
 * Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
 * The only good substring of length 3 is "xyz".
 */
public class CountGoodSubstring {
    public int countGoodSubstrings(String s) {
        //xyzzaz
        int count = 0, n = s.length();
        for(int i = 0; i <= n - 3; i++){
            if(s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i) != s.charAt(i + 2) &&
                    s.charAt(i + 1) != s.charAt(i + 2)){
                count++;
            }
        }
        return count;
    }
}
