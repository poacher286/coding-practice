package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class IntegerBreak {
    static int[] dp = new int[59];
    public static int integerBreak(int n) {
        if (n==1){
            return 1;
        }
        if (dp[n] != 0){
            return dp[n];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++){
            int prod = i * Math.max((n - i) , integerBreak(n - i));
            res = Math.max(prod, res);
        }
        return dp[n] = res;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }
}
