package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringAnagram {
    /**
     * count substring anagrams
     * Write a method that takes in a string and an anagram. The method should return the number of substrings that appear in the string that have the same characters as the anagram.
     *
     * You can assume that the anagram is not longer than the string.
     *
     */
    public static int countSubstringAnagrams(String s, String anagram) {
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> anagramMap = new HashMap<>();
        while (right < anagram.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            right++;
        }

        for (char c : anagram.toCharArray()) {
            anagramMap.put(c, anagramMap.getOrDefault(c, 0) + 1);
        }

        if (map.equals(anagramMap)) count++;

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (map.containsKey(s.charAt(left))) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
            }
            if (map.equals(anagramMap)) count++;
            right++;
            left++;
        }
        return count;
    }

}
