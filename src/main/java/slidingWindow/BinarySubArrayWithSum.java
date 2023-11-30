package slidingWindow;

/**
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 */
public class BinarySubArrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostK(nums, goal) - atMostK(nums, goal - 1);
    }

    public int atMostK(int[] nums, int goal){
        int left = 0;
        int right = 0;
        int sum = 0;
        int subArrayCount = 0;
        for(; right < nums.length; right++){
            sum += nums[right];
            for(; left <= right && sum > goal; left++){
                sum -= nums[left];
            }
            subArrayCount += right - left + 1;
        }
        return subArrayCount;
    }
}
