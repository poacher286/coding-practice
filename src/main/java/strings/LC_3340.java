package strings;

public class LC_3340 {
    /**
     * You are given a string num consisting of only digits. A string of digits is called balanced
     * if the sum of the digits at even indices is equal to the sum of digits at odd indices.
     *
     * Return true if num is balanced, otherwise return false.
     *
     *
     * @param num
     * @return
     */
    public static boolean isBalanced(String num) {
        int oddSum = 0;
        int evanSum = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if(i % 2 == 0) evanSum += digit;
            else oddSum += digit;
        }
        return oddSum == evanSum;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("24123"));
    }
}
