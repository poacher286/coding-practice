package twoPointers;

import java.util.HashMap;
import java.util.Map;

public class UnequalTriplets {
    /**
     * You are given a 0-indexed array of positive integers nums. Find the number of triplets (i, j, k) that meet the following conditions:
     *
     * 0 <= i < j < k < nums.length
     * nums[i], nums[j], and nums[k] are pairwise distinct.
     * In other words, nums[i] != nums[j], nums[i] != nums[k], and nums[j] != nums[k].
     * Return the number of triplets that meet the conditions.
     */
    public int unequalTriplets(int[] nums) {
        /**
         Suppose a value occurs freq times.

         left = number of elements before this value group
         right = number of elements after this value group

         Then every triplet choosing:

         one from left
         one from the current group (freq)
         one from right
         */

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int left = 0;
        int count = 0;
        int L = nums.length;

        for (int fr : freq.values()){
            int right = L - left - fr;// total - left - count(freq)
            count += left * fr * right;
            left += fr;
        }

        return count;
    }
}
