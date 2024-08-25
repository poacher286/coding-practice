package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class WeeklyContest412 {
    /**
     * You are given an integer array nums, an integer k, and an integer multiplier.
     *
     * You need to perform k operations on nums. In each operation:
     *
     * Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
     * Replace the selected minimum value x with x * multiplier.
     * Return an integer array denoting the final state of nums after performing all k operations.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,1,3,5,6], k = 5, multiplier = 2
     *
     * Output: [8,4,6,5,6]
     * @param nums
     * @param k
     * @param multiplier
     * @return
     */
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            // Find the index of the first occurrence of the minimum value
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // Replace the found minimum value with its multiplied result
            nums[minIndex] *= multiplier;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }
}
