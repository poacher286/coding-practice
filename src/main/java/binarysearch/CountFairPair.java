package binarysearch;

import java.util.Arrays;

public class CountFairPair {
    /**
     * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
     *
     * A pair (i, j) is fair if:
     *
     * 0 <= i < j < n, and
     * lower <= nums[i] + nums[j] <= upper
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
     * Output: 6
     * Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
     *
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return countLessOrEqual(nums, upper)
                - countLessOrEqual(nums, lower - 1);
    }

    private long countLessOrEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        long count = 0;

        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
