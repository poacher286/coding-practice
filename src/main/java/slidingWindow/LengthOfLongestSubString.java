package slidingWindow;

import java.util.*;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LengthOfLongestSubString {
    /**
     * We use a set (charSet) to keep track of unique characters in the current substring.
     * We maintain two pointers, left and right, to represent the boundaries of the current substring.
     * The maxLength variable keeps track of the length of the longest substring encountered so far.
     * We iterate through the string using the right pointer.
     * If the current character is not in the set (charSet), it means we have a new unique character.
     * We insert the character into the set and update the maxLength if necessary.
     * If the character is already present in the set, it indicates a repeating character within the current substring.
     * In this case, we move the left pointer forward, removing characters from the set until the repeating character is no longer present.
     * We insert the current character into the set and continue the iteration.
     * Finally, we return the maxLength as the length of the longest substring without repeating characters.
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()){
            if (!charSet.contains(s.charAt(right))){
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            }else{
                do{
                    charSet.remove(s.charAt(left++));
                }while(charSet.contains(s.charAt(right)));
                charSet.add(s.charAt(right));
            }
            right++;
        }
        return maxLength;
    }

    //return longest substring without repeating character
    public static String longestSubString(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currentChar);
            int currLength = right - left + 1;
            if (currLength > maxLength) {
                maxLength = currLength;
                ans = s.substring(left, right + 1);
            }
        }

        return ans;
    }


    public int lengthOfLongestSubstringMap(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }

        return maxLength;
    }


    public int lengthOfLongestSubstringIntArray(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringBoolArray(String s){
        int maxLength = 0;
        boolean[] boolArray = new boolean[256];
        for(int right = 0, left = 0; right < s.length(); right++){
            while(boolArray[s.charAt(right)]) {
                boolArray[s.charAt(left++)] = false;
            }
            boolArray[s.charAt(right)] = true;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(longestSubString(s));
    }
}
