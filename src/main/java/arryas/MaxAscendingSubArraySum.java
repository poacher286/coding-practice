package arryas;

public class MaxAscendingSubArraySum {
    /**
     * Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
     *
     * A subarray is defined as a contiguous sequence of numbers in an array.
     *
     * A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [10,20,30,5,10,50]
     * Output: 65
     * Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
     * @param nums
     * @return
     */
    public int maxAscendingSum(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int current = nums[i];
            if (((i+1) < nums.length) && nums[i+1] > current) {
                sum = sum + current;
            }
            else {
                sum = sum+current;
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        return max;
    }
}
