package twoPointers;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Example 2:
 *
 * Input: nums = [4,2,3,4]
 * Output: 4
 */
public class ValidTriangleNumber {
    public static int triangleNumber(int[] nums) {
        //sort
        Arrays.sort(nums);//[2,3,4,4]
        int count = 0;
        for (int k = 2; k < nums.length; k++) {
            int left = 0;
            int right = k - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
