package binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given an integer array nums. In one operation, you can replace any element in nums with any integer.
 *
 * nums is considered continuous if both of the following conditions are fulfilled:
 *
 * All elements in nums are unique.
 * The difference between the maximum element and the minimum element in nums equals nums.length - 1.
 * For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
 *
 * Return the minimum number of operations to make nums continuous.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,5,3]
 * Output: 0
 * Explanation: nums is already continuous.
 *
 * =====>
 * 1) Sort array
 * 2) MAX - MIN = N - 1
 *      ==> MAX = MIN + N - 1
 * consider ith element as MIN
 *      ==> find element to the right of ith index which is in range [MIN, MAX]
 */
public class MinOperations {
    public static int minOperations(int[] nums) {
        int length = nums.length;
        int minOPeration = Integer.MAX_VALUE;
        for (int min : nums) {
            int max = min + length - 1;// MAX - MIN = N - 1

            int opetations = 0;
            Set<Integer> integerSet = new HashSet<>();
            for (int num : nums) {
                if (num >= min && num <= max && !integerSet.contains(num)) {
                    integerSet.add(num);
                } else {
                    opetations++;
                }
            }
            minOPeration = Math.min(minOPeration, opetations);
        }

        return minOPeration;
    }


    public static int minOperationsOptimized(int[] a) {
        Arrays.sort(a);
        int r = a.length;
        Set<Integer> s = new HashSet<>();
        for(int i = 0, j = 0, right = a.length; j < a.length; i++){
            int last = a[i] + a.length - 1;
            while(j < a.length && a[j] <= last){
                s.add(a[j++]);
                right--;
            }
            int spots = a.length - s.size();
            r = Math.min(r, Math.max(i + right, spots));
            s.remove(a[i]);
        }
        return r;
    }


    public static void main(String[] args) {
        int[] nums = {8,5,9,9,8,4};
        System.out.println(minOperationsOptimized(nums));
    }
}
