package strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Reverse {
    //reverse a sentence/word

    /**
     * @param str - ABCD EFGH
     * @return - HGFE DCBA
     */
    public static String reverseString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }

    /**
     * @param sent - ABCD EFGH IJKL
     * @return - DBCA HGFE LKJI
     */
    public static String reverseSentence(String sent) {
        return Arrays.stream(sent.split("\\s+"))
                .map(Reverse::reverseString)
                .collect(Collectors.joining(" "));
    }

    /**
     * @param sent - ABCD EFGH IJKL
     * @return - IJKL EFGH ABCD
     */
    public static String reverseWord(String sent) {
        String[] split = sent.split("\\s+");
        for (int i = 0; i < split.length / 2; i++) {
            String temp = split[i];
            split[i] = split[split.length - i - 1];
            split[split.length - i - 1] = temp;
        }
        return String.join(" ", split);
    }

    public static boolean isPalindromeString(String str) {
        return str.equals(reverseString(str));
    }

    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
     * and removing all non-alphanumeric characters,
     * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        //POSIX class [\p{Alpha}\p{Digit}]
        //[\p{Alnum}], which matches with any alphanumeric character [A-Za-z0-9]
        //[^\p{Alnum}] --> NOT alphanumeric
        s = s.toLowerCase().replaceAll("[^\\p{Alnum}]", "");
        return s.equals(reverseString(s));
    }

    public static void main(String[] args) {
        System.out.println(reverseString("ABCD EFGH IJKL"));
        System.out.println(reverseSentence("ABCD EFGH IJKL"));
        System.out.println(isPalindromeString("nitin"));
        System.out.println(reverseWord("ABCD EFGH IJKL"));
    }
}
