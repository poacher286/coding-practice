package slidingWindow;

/**
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 */
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int[] chars = new int[26];
        int n = s.length();
        for (; right < n; right++){
            //right operation
            maxLen = Math.max(maxLen, ++chars[s.charAt(right) - 'A']);
            if (right - left + 1 > maxLen + k){//right - left + 1 > maxLen + k
                //left operation
                chars[s.charAt(left) - 'A']--;
                left++;
            }

        }
        return right - left;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
}
