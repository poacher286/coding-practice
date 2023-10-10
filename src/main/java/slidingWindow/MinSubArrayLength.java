package slidingWindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSubArrayLength {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int runningSum = 0;
        int minSubArrayLength = Integer.MAX_VALUE;
        while (right < nums.length){
            runningSum += nums[right++];

            while (runningSum >= target){
                minSubArrayLength = Math.min(minSubArrayLength, right - left);
                runningSum -= nums[left++];
            }
        }
        return minSubArrayLength != Integer.MAX_VALUE ? minSubArrayLength : 0;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
