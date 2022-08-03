package twoPointers;

import java.util.Arrays;

public class RearrangeBySign {
    /**
     * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
     *
     * You should rearrange the elements of nums such that the modified array follows the given conditions:
     *
     * Every consecutive pair of integers have opposite signs.
     * For all integers with the same sign, the order in which they were present in nums is preserved.
     * The rearranged array begins with a positive integer.
     * @param nums
     * @return
     */
    public static int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int left_pointer = 0;
        int right_pointer = 1;

        for (int num : nums) {
            if (num >= 0) {
                res[left_pointer] = num;
                left_pointer += 2;
            } else {
                res[right_pointer] = num;
                right_pointer += 2;
            }
        }

        return res;
    }

}
