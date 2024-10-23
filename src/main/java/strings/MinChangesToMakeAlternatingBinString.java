package strings;

public class MinChangesToMakeAlternatingBinString {
    /**
     * You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
     *
     * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
     *
     * Return the minimum number of operations needed to make s alternating.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "0100"
     * Output: 1
     * Explanation: If you change the last character to '1', s will be "0101", which is alternating.
     * Example 2:
     *
     * Input: s = "10"
     * Output: 0
     * Explanation: s is already alternating.
     * Example 3:
     *
     * Input: s = "1111"
     * Output: 2
     * Explanation: You need two operations to reach "0101" or "1010".
     * @param s
     * @return
     */
    public static int minOperations(String s) {
        int len = s.length();
        String s1 = "";
        String s2 = "";
        int countS1 = 0;
        int countS2 = 0;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 0) {
                s1 += "0";
                s2 += "1";
            }else{
                s1 += "1";
                s2 += "0";
            }
        }

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s1.charAt(i)){
                countS1++;
            }else if (s.charAt(i) != s2.charAt(i)){
                countS2++;
            }
        }

        return Math.min(countS1, countS2);
    }

    public static void main(String[] args) {
        String s = "0100";
//        String s = "10";
//        String s = "1111";
        System.out.println(minOperations(s));
    }
}
