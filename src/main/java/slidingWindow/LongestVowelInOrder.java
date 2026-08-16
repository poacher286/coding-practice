package slidingWindow;

public class LongestVowelInOrder {
    /**
     * A string is considered beautiful if it satisfies the following conditions:
     *
     * Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
     * The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).
     * For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.
     *
     * Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return 0.
     *
     * A substring is a contiguous sequence of characters in a string.
     */
    public int longestBeautifulSubstring(String word) {
        int left = 0;
        int right = 1;
        int distint = 1;
        int maxlength = 0;
        for (; right < word.length(); right++) {
            //right operation
            //if next element is greater than last element then update distint
            if (word.charAt(right) > word.charAt(right - 1)) distint++;
            else if (word.charAt(right) < word.charAt(right - 1)) {//if not then order is broken
                left = right;
                distint = 1;
            }

            //if all vowels are present
            if (distint == 5) {
                maxlength = Math.max(maxlength, right - left + 1);
            }
        }
        return maxlength;
    }
}
