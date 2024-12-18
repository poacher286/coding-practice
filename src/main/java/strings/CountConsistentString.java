package strings;

public class CountConsistentString {
    /**
     * You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
     *
     * Return the number of consistent strings in the array words.
     *
     *
     *
     * Example 1:
     *
     * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
     * Output: 2
     * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] map = new boolean[26];
        int consistent = words.length;

        for (char c : allowed.toCharArray()) {
            map[c - 'a'] = true;
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!map[c - 'a']){
                    consistent--;
                    break;
                }
            }
        }
        return consistent;
    }
}
