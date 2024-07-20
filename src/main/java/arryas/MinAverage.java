package arryas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinAverage {
    /**
     * You have an array of floating point numbers averages which is initially empty.
     * You are given an array nums of n integers where n is even.
     *
     * You repeat the following procedure n / 2 times:
     *
     * Remove the smallest element, minElement, and the largest element maxElement, from nums.
     * Add (minElement + maxElement) / 2 to averages.
     * Return the minimum element in averages.
     *
     * Input: nums = [7,8,3,4,15,13,4,1]
     *
     * Output: 5.5
     *
     * Explanation:
     *
     * step	nums	            averages
     * 0	[7,8,3,4,15,13,4,1]	[]
     * 1	[7,8,3,4,13,4]	    [8]
     * 2	[7,8,4,4]	        [8,8]
     * 3	[7,4]	            [8,8,6]
     * 4	[]	                [8,8,6,5.5]
     * The smallest element of averages, 5.5, is returned.
     * @param nums
     * @return
     */
    public static double minimumAverage(int[] nums) {
        int minMaxSum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while(left <= right){

            minMaxSum = Math.min(nums[left] + nums[right] , minMaxSum);

            left++;
            right--;
        }
        return (double) minMaxSum / 2;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,3,4,15,13,4,1};
        System.out.print(minimumAverage(nums));
    }
}
