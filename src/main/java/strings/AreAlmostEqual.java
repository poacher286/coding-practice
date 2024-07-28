package strings;

public class AreAlmostEqual {
    /**
     * You are given two strings s1 and s2 of equal length.
     * A string swap is an operation where you choose two indices in a string (not necessarily different)
     * and swap the characters at these indices.
     * <p>
     * Return true if it is possible to make both strings equal
     * by performing at most one string swap on exactly one of the strings. Otherwise, return false.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s1 = "bank", s2 = "kanb"
     * Output: true
     * Explanation: For example, swap the first character with the last character of s2 to make "bank".
     * Example 2:
     * <p>
     * Input: s1 = "attack", s2 = "defend"
     * Output: false
     * Explanation: It is impossible to make them equal with one string swap.
     * Example 3:
     * <p>
     * Input: s1 = "kelb", s2 = "kelb"
     * Output: true
     * Explanation: The two strings are already equal, so no string swap operation is required.
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int swap = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < s1.length() && swap < 2; i++) {
            int x = s1.charAt(i);// x = b // x=a.. //x=k
            int y = s2.charAt(i);// y = k // y=a.. //y=b

            if (a == y && b == x) { // a = 0, b = 0 // a = b, b = k .. //
                a = 0;
                b = 0;
            } else if (x != y) { // x != y // x==y
                swap++;//swap = 1
                a = x;//a = b
                b = y;//b = k
            }
        }
        return a + b == 0;
    }
}
