package test;

import java.util.Arrays;

public class Weekly441 {
    /**
     * You are given an integer array nums.
     *
     * You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:
     *
     * All elements in the subarray are unique.
     * The sum of the elements in the subarray is maximized.
     * Return the maximum sum of such a subarray.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.©leetcode
     * @param nums
     * @return
     */
    public int maxSum(int[] nums) {
        if (Arrays.stream(nums).allMatch(x -> x < 0)) {
            return Arrays.stream(nums).max().orElseThrow();
        }
        return Arrays.stream(nums).filter(x -> x > 0).distinct().sum();
    }
}
