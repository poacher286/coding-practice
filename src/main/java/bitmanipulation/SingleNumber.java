package bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        Set<Integer> setNum = new HashSet<>();
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
            setNum.add(num);
        }

        int setSum = 0;
        for (int num : setNum) {
            setSum += num * 2;
        }

        return setSum - arraySum;
    }

    public static int singleNumberXOR(int[] nums){
        //XOR with itself is always 0
        int ans = 0;
        for (int num : nums) {
            ans = ans^num;
        }
        return ans;
    }

    public static int singleNumberForTriplet(int[] nums) {
        Set<Integer> setNum = new HashSet<>();
        long arraySum = 0;
        for (int num : nums) {
            arraySum += num;
            setNum.add(num);
        }

        long setSum = 0;
        for (int num : setNum) {
            setSum += num * 3L;
        }

        return (int) ((setSum - arraySum) / 2);
    }

    public static void main(String[] args) {
//        int[] nums = {4,1,2,1,2};
        int[] nums = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
        System.out.println(singleNumberForTriplet(nums));
//        System.out.println(singleNumberXOR(nums));
    }
}
