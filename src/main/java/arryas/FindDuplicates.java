package arryas;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 */
public class FindDuplicates {
    public static int findDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            if (!integerSet.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
