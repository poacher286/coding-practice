package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramString {
    /**
     * Given two strings s and p,
     * return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     * Approach
     * s.length() < p.length() -> return null
     * p -> sort
     * s -> substring with p.length
     * substring -> sort
     * check substring == p
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;

        char[] ch = p.toCharArray();
        Arrays.sort(ch);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] subChar = s.substring(i, p.length() + i).toCharArray();
            Arrays.sort(subChar);

            if (Arrays.equals(ch, subChar))
                ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}
