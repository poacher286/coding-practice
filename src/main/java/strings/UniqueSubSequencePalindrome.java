package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
 *
 * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 *
 * A palindrome is a string that reads the same forwards and backwards.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 *
 * Example 1:
 *
 * Input: s = "aabca"
 * Output: 3
 */
public class UniqueSubSequencePalindrome {
    public static int countPalindromicSubsequence(String s) {//3 digit palindrome
        int res = 0;
        Set<Character> uniq = new HashSet<>();

        for (char c : s.toCharArray()) {
            uniq.add(c);
        }

        for (char c : uniq) {
            int start = s.indexOf(c);
            int end = s.lastIndexOf(c);

            if (start < end) {
                Set<Character> charSet = new HashSet<>();
                for (int i = start + 1; i < end; i++) {
                    charSet.add(s.charAt(i));
                }
                res += charSet.size();
            }
        }

        return res;
    }


    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
    }
}
