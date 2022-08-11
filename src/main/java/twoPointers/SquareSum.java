package twoPointers;

public class SquareSum {
    /**
     * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (int)Math.sqrt(c);
        while (left <= right) {
            if (left * left + right * right == c) return true;//always check for valid condition first
            else if (left * left + right * right < c) left++;
            else right--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(1000000));
    }
}
