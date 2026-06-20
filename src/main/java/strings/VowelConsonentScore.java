package strings;

public class VowelConsonentScore {
    /**
     * 3813. Vowel-Consonant Score
     * Easy
     * You are given a string s consisting of lowercase English letters, spaces, and digits.
     * <p>
     * Let v be the number of vowels in s and c be the number of consonants in s.
     * <p>
     * A vowel is one of the letters 'a', 'e', 'i', 'o', or 'u', while any other letter in the English alphabet is considered a consonant.
     * <p>
     * The score of the string s is defined as follows:
     * <p>
     * If c > 0, the score = floor(v / c) where floor denotes rounding down to the nearest integer.
     * Otherwise, the score = 0.
     * Return an integer denoting the score of the string.
     *
     * @param s
     * @return
     */
    public int vowelConsonantScore(String s) {
        int score = 0;
        int v = 0, c = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (isVowel(ch)) v++;
                else c++;
            }
        }
        if (c > 0) {
            score = Math.floorDiv(v, c);
        }
        return score;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
