package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberII {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        /*
          Since House[1] and House[n] are adjacent,
          they cannot be robbed together.
          Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n],
          depending on which choice offers more money.
          Now the problem has degenerated to the House Robber, which is already been solved.
         */
        //Use separate memo maps for each subproblem:
        Map<Integer, Integer> memo1 = new HashMap<>();
        Map<Integer, Integer> memo2 = new HashMap<>();

        int zeroToLenMinusTwo = rob(nums, 0, nums.length - 2, memo1);
        int oneToLenMinusOne = rob(nums, 1, nums.length - 1, memo2);

        return Math.max(zeroToLenMinusTwo, oneToLenMinusOne);
    }

    private int rob(int[] nums, int start, int end, Map<Integer, Integer> memo) {
        if (end < start) return 0;

        if (memo.containsKey(end)) return memo.get(end);

        int include = rob(nums, start, end - 2, memo) + nums[end];
        int exclude = rob(nums, start, end - 1, memo);

        int result = Math.max(include, exclude);
        memo.put(end, result);
        return result;
    }
}
