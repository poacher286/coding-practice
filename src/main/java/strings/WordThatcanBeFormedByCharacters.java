package strings;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 */
public class WordThatcanBeFormedByCharacters {
    public static int countCharacters(String[] words, String chars) {
        int[] mapChars = new int[26];
        int ans = 0;
        for (char c : chars.toCharArray()) {
            mapChars[c - 'a']++;
        }

        for (String word : words) {
            int[] freqWord = new int[26];
            for (char c : word.toCharArray()) {
                freqWord[c - 'a']++;
            }

            boolean possible = true;
            for(int i = 0; i < 26; i++){
                if (freqWord[i] > mapChars[i]){
                    possible = false;
                    break;
                }
            }

            if (possible){
                ans += word.length();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }
}
