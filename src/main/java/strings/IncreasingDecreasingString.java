package strings;

public class IncreasingDecreasingString {
    /**
     * You are given a string s. Reorder the string using the following algorithm:
     *
     * Pick the smallest character from s and append it to the result.
     * Pick the smallest character from s which is greater than the last appended character to the result and append it.
     * Repeat step 2 until you cannot pick more characters.
     * Pick the largest character from s and append it to the result.
     * Pick the largest character from s which is smaller than the last appended character to the result and append it.
     * Repeat step 5 until you cannot pick more characters.
     * Repeat the steps from 1 to 6 until you pick all characters from s.
     * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
     *
     * Return the result string after sorting s with this algorithm.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aaaabbbbcccc"
     * Output: "abccbaabccba"
     * @param s
     * @return
     */
    public String sortString(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {//increasing append
                if(charCount[i] > 0){
                    sb.append((char) (i + 'a'));
                    charCount[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {//decreasing append
                if(charCount[i] > 0){
                    sb.append((char) (i + 'a'));
                    charCount[i]--;
                }
            }
        }
        return sb.toString();
    }
}
