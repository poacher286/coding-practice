package twoPointers;

import java.util.Arrays;

/**
 * Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
 *
 * Return the positive integer k. If there is no such integer, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,-3,3]
 * Output: 3
 * Explanation: 3 is the only valid k we can find in the array.
 *
 * ==> find 2 number whose sum = 0
 */
public class FindMaxK {
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] < 0){
                left++;
            }else if(nums[left] + nums[right] > 0){
                right--;
            }else{
                return nums[right];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,-3,3};
        System.out.println(findMaxK(nums));
    }
}
