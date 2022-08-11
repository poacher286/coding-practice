package twoPointers;

import java.util.Arrays;

public class MinPairSum {
    /**
     * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
     *
     * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
     * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
     *
     * Each element of nums is in exactly one pair, and
     * The maximum pair sum is minimized.
     * Return the minimized maximum pair sum after optimally pairing up the elements.
     * @param nums
     * @return
     */
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int minPairSum = 0;
        while (left <= right) minPairSum = Math.max(minPairSum, nums[left++] + nums[right--]);
        return minPairSum;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,2,3};
        System.out.println(minPairSum(nums));
    }
}

