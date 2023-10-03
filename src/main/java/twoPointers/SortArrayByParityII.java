package twoPointers;

import java.util.Arrays;

/**
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 *
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 *
 * Return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 */
public class SortArrayByParityII {
    public static int[] sortArrayByParityII(int[] nums) {
        //[4,2,5,7]
        int left = 0;
        int right = 1;

        int[] result = new int[nums.length];

        for(int num : nums){
            if((num & 1) == 0){
                result[left] = num;
                left += 2;
            }else{
                result[right] = num;
                right += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }
}
