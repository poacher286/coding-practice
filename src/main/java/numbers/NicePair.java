package numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array nums that consists of non-negative integers.
 * Let us define rev(x) as the reverse of the non-negative integer x.
 * For example, rev(123) = 321, and rev(120) = 21.
 * A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [42,11,1,97]
 * Output: 2
 */
public class NicePair {
    public static int countNicePairs(int[] nums) {
        //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //==> nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            nums[i] = nums[i] - rev(nums[i]);
        }

        Map<Integer, Integer> integerMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int fr;
            integerMap.put(num, fr = integerMap.getOrDefault(num, 0) + 1);
            res = (int) (((long) res + fr - 1) % 1000000007);
        }
        return res;
    }

    public static int rev(int num){
        int rev = 0;
        while(num > 0){
            int rem = num % 10;
            rev = rem + (rev * 10);
            num = num / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int[] nums = {42,11,1,97};
        System.out.println(countNicePairs(nums));
    }
}
