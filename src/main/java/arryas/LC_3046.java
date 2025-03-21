package arryas;

import java.util.HashMap;
import java.util.Map;

public class LC_3046 {
    /**
     * You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:
     *
     * nums1.length == nums2.length == nums.length / 2.
     * nums1 should contain distinct elements.
     * nums2 should also contain distinct elements.
     * Return true if it is possible to split the array, and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,2,2,3,4]
     * Output: true
     * @param nums
     * @return
     */
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int value : freq.values()) {
            if (value > 2){
                return false;
            }
        }
        return true;
    }

    public boolean isPossibleToSplit2(int[] nums) {
        int[] cnt = new int[101];
        for (int x : nums) {
            if (++cnt[x] >= 3) {
                return false;
            }
        }
        return true;
    }
}
