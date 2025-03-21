package strings;

public class LC_3271 {
    /**
     * You are given a string s of length n and an integer k, where n is a multiple of k. Your task is to hash the string s into a new string called result, which has a length of n / k.
     *
     * First, divide s into n / k substrings, each with a length of k. Then, initialize result as an empty string.
     *
     * For each substring in order from the beginning:
     *
     * The hash value of a character is the index of that character in the English alphabet (e.g., 'a' → 0, 'b' → 1, ..., 'z' → 25).
     * Calculate the sum of all the hash values of the characters in the substring.
     * Find the remainder of this sum when divided by 26, which is called hashedChar.
     * Identify the character in the English lowercase alphabet that corresponds to hashedChar.
     * Append that character to the end of result.
     * Return result.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcd", k = 2
     *
     * Output: "bf"
     *
     * Explanation:
     *
     * First substring: "ab", 0 + 1 = 1, 1 % 26 = 1, result[0] = 'b'.
     *
     * Second substring: "cd", 2 + 3 = 5, 5 % 26 = 5, result[1] = 'f'.
     * @param s
     * @param k
     * @return
     */
    public static String stringHash(String s, int k) {
        String ans = "";

        for (int x = 0; x < s.length(); x = x + k){
            int sum = 0;
            for (int i = x; i < x + k; i++) {
                sum += s.charAt(i) - 'a';
            }
            int hashedChar = sum % 26;
            ans += Character.toString('a' + hashedChar);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(stringHash(s, k));
    }
}
