package arryas;

import java.util.Arrays;

/**
 * Given an integer array nums, your goal is to make all elements in nums equal. To complete one operation, follow these steps:
 *
 * Find the largest value in nums. Let its index be i (0-indexed) and its value be largest. If there are multiple elements with the largest value, pick the smallest i.
 * Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.
 * Reduce nums[i] to nextLargest.
 * Return the number of operations to make all elements in nums equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,1,3]
 * Output: 3
 */
public class ReductionOperation {
    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ops = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            ops += n - i;
        }
        return ops;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.println(reductionOperations(nums));
    }
}
