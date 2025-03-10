package arryas;

import java.util.*;
import java.util.stream.Collectors;

public class MaxSumPairWithEqualSumDigits {
    /**
     * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
     *
     * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [18,43,36,13,7]
     * Output: 54
     * Explanation: The pairs (i, j) that satisfy the conditions are:
     * - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
     * - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
     * So the maximum sum that we can obtain is 54.
     * @param nums
     * @return
     */
    public static int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int sum = digitSum(num);
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(num);
        }
        int maxSum = -1;
        for (List<Integer> arr : map.values()) {
            if (arr.size() >= 2) {
                int firstMax = 0, secondMax = 0;
                for (int x : arr) {
                    if (x > firstMax) {
                        secondMax = firstMax;
                        firstMax = x;
                    } else if (x > secondMax) {
                        secondMax = x;
                    }
                }
                maxSum = Math.max(maxSum, firstMax + secondMax);
            }
        }
        return maxSum;
    }

    public static int digitSum(int n){
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,10,6};
        System.out.println(maximumSum(nums));
    }
}
