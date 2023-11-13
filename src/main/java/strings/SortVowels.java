package strings;

import java.util.Arrays;

/**
 * Given a 0-indexed string s, permute s to get a new string t such that:
 *
 * All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
 * The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
 * Return the resulting string.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "lEetcOde"
 * Output: "lEOtcede"
 * Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.
 */
public class SortVowels {
    public static String sortVowels(String s) {
        char[] vowels = new char[s.length()];
        Arrays.fill(vowels, 'u');

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowels[i] = s.charAt(i);
            }
        }
        Arrays.sort(vowels);
        String t = "";
        int vowelIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                t += vowels[vowelIdx++];
            }else {
                t += s.charAt(i);
            }
        }
        return t;
    }
    
    public static boolean isVowel(char c){
        return c == 'A' || c == 'E' || c == 'I' || c =='O' || c == 'U' ||
                c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u';
    }

    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sortVowels(s));
    }

}
