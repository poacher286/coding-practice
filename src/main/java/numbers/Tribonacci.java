package numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 */
public class Tribonacci {
    public static int tribonacci(int n) {
        return tribonacciMemoDP(n, new HashMap<>());
    }

    public static int tribonacciMemoDP(int n, Map<Integer, Integer> memo){
        if (memo.containsKey(n)){
            return memo.get(n);
        }
        if (n == 0){
            return 0;
        }
        if (n < 3){
            return 1;
        }

        memo.putIfAbsent(n, tribonacciMemoDP(n - 1, memo) + tribonacciMemoDP(n - 2, memo) + tribonacciMemoDP(n - 3, memo));
        return memo.get(n);
    }

    public int tribonacciSol2(int n) {
        if(n==1 || n==2){
            return 1;
        }
        if(n==0){
            return 0;
        }
        int one = 0  , two = 1 , three = 1 , val = 0;
        for(int i = 3 ; i <= n ; i++){
            val = one + two + three;
            one = two;
            two = three;
            three = val;
        }
        return val;
    }

    public static int tribonacciSol3(int n) {
        if (n == 0){
            return 0;
        }
        if (n < 3){
            return 1;
        }

        return tribonacciSol3(n - 1) + tribonacciSol3(n - 2) + tribonacciSol3(n - 3);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci(n));
    }
}
