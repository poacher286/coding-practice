package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) + 1);
            }else{
                charCount.put(c, 1);
            }
        }

        int longestPalindromLength = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()){
                longestPalindromLength += entry.getValue()/2 * 2;
                if (longestPalindromLength % 2 ==0 && entry.getValue() % 2 !=0) longestPalindromLength++;
        }

        return longestPalindromLength;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
