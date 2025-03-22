package slidingWindow;

import java.util.Arrays;

public class LC_594 {
    /**
     * We define a harmonious array as an array where
     * the difference between its maximum value and its minimum value is exactly 1.
     *
     * Given an integer array nums,
     * return the length of its longest harmonious subsequence among all its possible subsequences.
     *
     * Example 1:
     *
     * Input: nums = [1,3,2,2,5,2,3,7]
     *
     * Output: 5
     *
     * Explanation:
     *
     * The longest harmonious subsequence is [3,2,2,2,3].
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = 1, res = 0;
        while (r < nums.length) {
            int d = nums[r] - nums[l];
            if (d == 1) res = Math.max(res, r - l + 1);
            if (d <= 1) r++;
            else l++;
        }
        return res;
    }
}
