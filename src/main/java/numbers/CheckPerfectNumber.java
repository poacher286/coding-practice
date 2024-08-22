package numbers;

public class CheckPerfectNumber {
    /**
     * A perfect number is a positive integer that is equal to the sum of its positive divisors,
     * excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
     *
     * Given an integer n, return true if n is a perfect number, otherwise return false.
     *
     * Example 1:
     *
     * Input: num = 28
     * Output: true
     * Explanation: 28 = 1 + 2 + 4 + 7 + 14
     * 1, 2, 4, 7, and 14 are all divisors of 28.
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber(int num) {
        int count = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0){
                count += i;
            }
        }
        return count == num;
    }

    public static void main(String[] args) {
        int num = 28;
        System.out.println(checkPerfectNumber(num));
    }
}
