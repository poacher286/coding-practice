package twoPointers;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * ====>
 * First of all, sort the array
 * i)For each value we find two sum closest.
 * ii)Add arr[i] to two sum closest to get three sum.
 * iii)find difference between target and three sum.
 * iv)Minimum difference would be the closest three sum.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 2;
        int closest3Sum = Integer.MIN_VALUE;
        while (left < right){
            int sum3 = nums[left] + twoSumClosest(nums, target - nums[left], left);
            if (closest3Sum == Integer.MIN_VALUE || Math.abs(sum3 - target) < Math.abs(closest3Sum - target)){
                closest3Sum = sum3;
            }
            left++;
        }
        return closest3Sum;
    }

    public static int twoSumClosest(int[] nums, int target, int start){
        int left = start + 1;
        int right = nums.length - 1;
        int closest2Sum = Integer.MIN_VALUE;
        while (left < right){
            int sum2 = nums[left] + nums[right];
            if (closest2Sum == Integer.MIN_VALUE || Math.abs(sum2 - target) < Math.abs(closest2Sum - target)){
                closest2Sum = sum2;
            }
            if (sum2 < target){
                left++;
            }else if (sum2 > target){
                right--;
            }else{
                return sum2;
            }
        }
        return closest2Sum;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,2,1,-4};
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        System.out.println(threeSumClosest(nums, target));
    }
}
