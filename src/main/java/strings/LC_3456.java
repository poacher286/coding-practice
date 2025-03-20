package strings;

public class LC_3456 {
    /**
     * You are given a string s and an integer k.
     *
     * Determine if there exists a substring of length exactly k in s that satisfies the following conditions:
     *
     * The substring consists of only one distinct character (e.g., "aaa" or "bbb").
     * If there is a character immediately before the substring, it must be different from the character in the substring.
     * If there is a character immediately after the substring, it must also be different from the character in the substring.
     * Return true if such a substring exists. Otherwise, return false.
     * @param s
     * @param k
     * @return
     */
    public static boolean hasSpecialSubstring(String s, int k) {
        int cons_count = 1;
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i + 1)){
                cons_count++;

            }else {
                if(cons_count == k){
                    return true;
                }
                cons_count = 1;
            }

        }
        return cons_count == k;
    }

    public static void main(String[] args) {
        String s = "a";
        int k = 1;
        System.out.println(hasSpecialSubstring(s, k));
    }
}
