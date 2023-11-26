package slidingWindow;

import java.util.Arrays;

/**
 * You are given an integer array nums sorted in non-decreasing order.
 *
 * Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.
 *
 * In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,5]
 * Output: [4,3,5]
 */
public class SumOfAbsoluteDifference {
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int sumBelow = 0;
        int sumTotal = Arrays.stream(nums).sum();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            sumTotal -= num;
            res[i] = sumTotal - (n - i - 1) * num + i * num - sumBelow;
            sumBelow += num;
        }
        return res;
    }
}
