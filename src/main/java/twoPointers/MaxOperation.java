package twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 *
 */
public class MaxOperation {

    public static int maxOperations(int[] nums, int k) {
        int maxOperation = 0;
        int left_pointer = 0;
        int right_pointer = nums.length - 1;
        Arrays.sort(nums);
        while (left_pointer < right_pointer){
            if (nums[left_pointer] + nums[right_pointer] < k){
                left_pointer++;
            }else if(nums[left_pointer] + nums[right_pointer] > k){
                right_pointer--;
            }else{
                maxOperation++;
                left_pointer++;
                right_pointer--;
            }
        }

        return maxOperation;
    }


    public static int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int res = k - num;
            if (map.containsKey(res)) {
                count++;
                if (map.get(res) == 1) map.remove(res);
                else map.put(res, map.get(res) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int k = 2;
        System.out.println(maxOperations2(nums, k));
    }
}
