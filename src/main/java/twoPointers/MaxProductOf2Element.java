package twoPointers;

import java.util.Arrays;

/**
 * Given the array of integers nums,
 * you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 *
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,2]
 * Output: 12
 */
public class MaxProductOf2Element {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2];
    }

    public int maxProduct2(int[] nums) {
        int firstMax = -1;
        int secMax = -1;
        for (int num : nums) {
            if (num > firstMax) {
                secMax = firstMax;
                firstMax = num;
            }else if (num > secMax){
                secMax = num;
            }
        }
        return (firstMax - 1) * (secMax - 1);
    }
}
