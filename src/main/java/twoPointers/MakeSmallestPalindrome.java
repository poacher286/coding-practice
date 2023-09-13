package twoPointers;

import java.util.Arrays;

/**
 *
 *You are given a string s consisting of lowercase English letters, and you are allowed to perform operations on it. In one operation, you can replace a character in s with another lowercase English letter.
 *
 * Your task is to make s a palindrome with the minimum number of operations possible. If there are multiple palindromes that can be made using the minimum number of operations, make the lexicographically smallest one.
 *
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b.
 *
 * Return the resulting palindrome string.
 *
 * Input: s = "egcfe"
 * Output: "efcfe"
 * Explanation: The minimum number of operations to make "egcfe" a palindrome is 1, and the lexicographically smallest palindrome string we can get by modifying one character is "efcfe", by changing 'g'.
 */
public class MakeSmallestPalindrome {

    public static String makeSmallestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while(left < right) {
            if(chars[left] != chars[right]) {
                char c = (char) Math.min(chars[left], chars[right]);
                chars[left] = chars[right] = c;
            }
            left++;
            right--;
        }
        String ans = "";
        for (char aChar : chars) {
            ans += aChar;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "egcfe";
        System.out.println(makeSmallestPalindrome(s));

    }
}
