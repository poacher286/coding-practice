package twoPointers;

import java.util.Arrays;

/**
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 *
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 *
 * Approach
 * For each index S[i], let's try to find the distance to the next character C going left, and going right.
 * The answer is the minimum of these two values.
 *
 * -> run 2 for loops
 *      1 left to right
 *      2 right to left
 *
 * -> while going left to right assign
 *
 */
public class SortestToCharacter {

    public static int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        int previous = -1 * s.length();
        //left to right loop
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                previous = i;
            }
            ans[i] = i - previous;
        }

        //right to left
        previous = s.length() * 2;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                previous = i;
            }
            ans[i] = Math.min(ans[i], previous - i);
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToChar(s, c)));
    }
}
