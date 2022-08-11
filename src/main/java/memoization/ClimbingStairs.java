package memoization;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     *            0
     *         /    \
     *        1       2
     *      /  \     /
     *     2    3   3
     *    /
     *   3
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairsMemo(n, memo);
    }

    public int climbStairsMemo(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 1) return 1;
        memo.put(n , climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo));
        return memo.get(n);
    }

    public int climbStairsRecurssion(int n) {
        if (n <= 1) return 1;
        return climbStairsRecurssion(n-1) + climbStairsRecurssion(n-2);
    }
}
