package twoPointers;

public class ReversePrefixOfWord {
    /**
     * Given a 0-indexed string word and a character ch,
     * reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
     * If the character ch does not exist in word, do nothing.
     *
     * For example, if word = "abcdefd" and ch = "d",
     * then you should reverse the segment that starts at 0 and ends at 3 (inclusive).
     * The resulting string will be "dcbaefd".
     * Return the resulting string.
     *
     * Approach-
     * find first occurance of ch
     * substring the string
     * reverse the substring
     * add in string
     * @param word
     * @param ch
     * @return
     */
    public static String reversePrefix(String word, char ch) {
        String end = word.substring(word.indexOf(ch) + 1);
        String pre = word.substring(0, word.indexOf(ch) + 1);
        String reversePrefix = "";
        for (int i = pre.length() -1 ; i >=0; i--) {
            reversePrefix += pre.charAt(i);
        }

        return reversePrefix + end;
    }

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }
}
