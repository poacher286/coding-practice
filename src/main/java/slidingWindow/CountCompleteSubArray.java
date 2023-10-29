package slidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * You are given an array nums consisting of positive integers.
 *
 * We call a subarray of an array complete if the following condition is satisfied:
 *
 * The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
 * Return the number of complete subarrays.
 *
 * A subarray is a contiguous non-empty part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,1,2,2]
 * Output: 4
 * Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
 */
public class CountCompleteSubArray {
    public static int countCompleteSubarrays(int[] nums) {
        int count = 0;
        int distinct = (int) Arrays.stream(nums).distinct().count();
        for (int i = 0; i < nums.length; i++){
            Set<Integer> integerSet = new HashSet<>();
            for (int j = i; j < nums.length; j++){
                integerSet.add(nums[j]);
                if (integerSet.size() == distinct){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(nums));
    }
}
