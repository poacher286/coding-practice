package slidingWindow;

public class MaxSubArray {
    /**
     * Given an integer array nums, find the
     * subarray
     *  with the largest sum, and return its sum.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int currSUm = 0;
        for (int n : nums) {
            currSUm = Math.max(currSUm, 0);
            currSUm += n;
            res = Math.max(res, currSUm);
        }
        return res;
    }
}
