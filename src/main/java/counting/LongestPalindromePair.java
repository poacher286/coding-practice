package counting;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromePair {
    /**
     * You are given an array of strings words. Each element of words consists of two lowercase English letters.
     *
     * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
     *
     * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
     *
     * A palindrome is a string that reads the same forward and backward.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["lc","cl","gg", lc]
     * Output: 6
     * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
     * Note that "clgglc" is another longest palindrome that can be created.
     */

    public static int longestPalindrome(String[] words) {
        Map<String, Integer> freq_map = new HashMap<>();
        for (String word : words) {
            freq_map.put(word, freq_map.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        int alreadyPalindrome = 0;
        for (String word : freq_map.keySet()) {
            int freq = freq_map.get(word);
            if (freq == 0) continue;

            String reverse = new StringBuilder(word).reverse().toString();
            if (word.equals(reverse)){
                count += (freq / 2) * 4;
                if (freq % 2 == 1) alreadyPalindrome = 1;
            }else if (freq_map.containsKey(reverse)){
                int pair = Math.min(freq, freq_map.get(reverse));
                count += pair * 4;
                freq_map.put(reverse, 0);
            }
            freq_map.put(word, 0);
        }

        return count + alreadyPalindrome * 2;
    }

    public static void main(String[] args) {
        String[] words = {"lc","cl","gg"};
        System.out.println(longestPalindrome(words));
    }
}
