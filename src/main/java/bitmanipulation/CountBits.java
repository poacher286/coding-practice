package bitmanipulation;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an integer n,
 * return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class CountBits {

    public static int[] countBits(int n) {
        return IntStream.range(0, n + 1).map(CountBits::count1InNum).toArray();
    }

    public static int count1InNum(int num){
        int count = 0;
        while (num != 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }
}
