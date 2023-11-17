package slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a 0-indexed integer array nums. A pair of integers x and y is called a strong pair if it satisfies the condition:
 *
 * |x - y| <= min(x, y)
 * You need to select two integers from nums
 * such that they form a strong pair
 * and their bitwise XOR is the maximum among all strong pairs in the array.
 *
 * Return the maximum XOR value out of all possible strong pairs in the array nums.
 *
 * Note that you can pick the same integer twice to form a pair.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: 7
 */
public class MaxStrongpairXORI {
    public static int maximumStrongPairXor(int[] nums) {
        List<int[]> strongPair = new ArrayList<>();
        for (int x : nums) {
            for (int y : nums) {
                int[] pair = new int[2];
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    pair[0] = x;
                    pair[1] = y;
                    strongPair.add(pair);
                }
            }
        }

        int maxXOR = 0;
        for (int[] pr : strongPair) {
            maxXOR = Math.max(maxXOR, pr[0] ^ pr[1]);
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(maximumStrongPairXor(nums));
    }
}
