package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class HasSubstringAnagram {
    /**
     * has substring anagram
     * Write a function that takes in a string and an anagram. The function should return a boolean indicating whether or not the string contains a substring with the same characters as the anagram.
     *
     * You can assume that the string contains no duplicate characters.
     *
     * You can assume that the anagram contains no duplicate characters.
     *
     * You can assume that the anagram is not longer than the string.
     */
    public static boolean hasSubstringAnagram(String s, String anagram) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < anagram.length()){
            //add the first anagram.length() element from s in set
            set.add(s.charAt(right++));
        }

        Set<Character> anagramSet = new HashSet<>();
        for (char c : anagram.toCharArray()) {
            anagramSet.add(c);
        }

        if (anagramSet.equals(set)) {//its always good to match first and move ahead
            return true;
        }
        while (right < s.length()) {
            //check anagram chars in set
            //if not present
            //add from right and remove from left
            set.add(s.charAt(right++));
            set.remove(s.charAt(left++));
            if (anagramSet.equals(set)) {//we check at the end so that it will check for last element also
                return true;
            }
        }
        return false;
    }
}
