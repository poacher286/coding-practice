package slidingWindow;

public class LongestMonotonic {
    /**
     * You are given an array of integers nums. Return the length of the longest
     * subarray
     *  of nums which is either
     * strictly increasing
     *  or
     * strictly decreasing
     * .
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,4,3,3,2]
     *
     * Output: 2
     *
     * Explanation:
     *
     * The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
     *
     * The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
     *
     * Hence, we return 2.
     * @param nums
     * @return
     */
    public static int longestMonotonicSubarray(int[] nums) {
        //loop  left = 0
        //      right = 1
        //if nums[right] > nums[left]
            // continue loop and increment maxIncrease
        //else
            // left = right
            // right = left + 1
        // repeat this step for maxDecrease
        // return max(maxIncrease, maxDecrease)
        int left = 0;
        int ans = 1;

        for (int right = 1; right < nums.length; right++) {
            if (nums[right] > nums[right - 1]) {
                ans = Math.max(ans, right - left + 1);
            }
            else {
                left = right;
            }
        }

        left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] < nums[right - 1]) {
                ans = Math.max(ans, right - left + 1);
            }
            else {
                left = right;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(longestMonotonicSubarray(nums));
    }
}
