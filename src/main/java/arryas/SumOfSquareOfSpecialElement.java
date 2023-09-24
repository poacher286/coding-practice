package arryas;

/**
 * You are given a 1-indexed integer array nums of length n.
 *
 * An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.
 *
 * Return the sum of the squares of all special elements of nums.
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 21
 */
public class SumOfSquareOfSpecialElement {
    public static int sumOfSquares(int[] nums) {
        int sumOfSquare = 0;
        for (int i = 0; i < nums.length; i++) {
            if(getRemainder(nums.length, i+1) == 0){
                sumOfSquare += nums[i]*nums[i];
            }
        }
        return sumOfSquare;
    }

    private static int getRemainder(int num, int divisor) {
        return (num - divisor * (num / divisor));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(sumOfSquares(nums));
    }
}
