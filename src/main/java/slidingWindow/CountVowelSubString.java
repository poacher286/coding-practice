package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * A substring is a contiguous (non-empty) sequence of characters within a string.
 *
 * A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.
 *
 * Given a string word, return the number of vowel substrings in word.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "aeiouu"
 * Output: 2
 */
public class CountVowelSubString {
    public static int countVowelSubstrings(String word) {
        return atMostKVowel(word, 5) - atMostKVowel(word, 4);
    }

    public static int atMostKVowel(String word, int k){
        int l = word.length();
        int left = 0;
        int right = 0;
        Map<Character, Integer> vowelMap = new HashMap<>();
        int count = 0;

        for(; right < l; right++){
            //right operation to increase window size
            char chRight = word.charAt(right);
            if (!isVowel(chRight)){//consonent
                //clear map
                vowelMap.clear();
                left = right + 1;// new substring will start
                continue;
            }
            vowelMap.put(chRight, vowelMap.getOrDefault(chRight, 0) + 1);
            for (; vowelMap.size() > k; left++){
                // left operation to shrink window
                char chLeft = word.charAt(left);
                vowelMap.put(chLeft, vowelMap.get(chLeft) - 1);
                if (vowelMap.get(chLeft) == 0){//if empty then remove
                    vowelMap.remove(chLeft);
                }
            }
            count += right - left + 1;
        }

        return count;
    }

    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String word = "cuaieuouac";
        System.out.println(countVowelSubstrings(word));
    }
}
