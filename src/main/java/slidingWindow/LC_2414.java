package slidingWindow;

public class LC_2414 {
    /**
     * An alphabetical continuous string is a string consisting of consecutive letters in the alphabet. In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".
     *
     * For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
     * Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.
     * @param s
     * @return
     */
    public int longestContinuousSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            //right operation to make window valid
            if (right > 0 && s.charAt(right - 1) + 1 != s.charAt(right)) {
                left = right;
            }

            maxLength = Math.max(maxLength, right - left + 1); //continue counting
        }
        return maxLength;
    }
}
