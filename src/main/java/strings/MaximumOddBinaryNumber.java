package strings;

import java.util.Arrays;

/**
 * You are given a binary string s that contains at least one '1'.
 *
 * You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.
 *
 * Return a string representing the maximum odd binary number that can be created from the given combination.
 *
 * Note that the resulting string can have leading zeros.
 */
public class MaximumOddBinaryNumber {

    public static String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(chars[i]);
        }
        sb.reverse();
        sb.append(chars[s.length()-1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "0101";
        System.out.println(maximumOddBinaryNumber(s));
    }
}
