package slidingWindow;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 */
public class MaxVowelInString {
    public static int maxVowels(String s, int k) {
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))){
                vowelCount++;
            }
        }

        int maxVowelCount = vowelCount;
        int left = 0;
        int right = k;
        while(right < s.length()){
            if(isVowel(s.charAt(left)) && maxVowelCount>0) {
                vowelCount--;
            }
            if(isVowel(s.charAt(right))) {
                vowelCount++;
            }
            left++;
            right++;
            maxVowelCount = Math.max(maxVowelCount, vowelCount);
        }
        return maxVowelCount;
    }

    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }
}
