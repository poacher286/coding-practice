package bitmanipulation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * You are given a 0-indexed integer array nums and an integer k.
 *
 * Return an integer that denotes the sum of elements in nums whose corresponding indices have exactly k set bits in their binary representation.
 *
 * The set bits in an integer are the 1's present when it is written in binary.
 *
 * For example, the binary representation of 21 is 10101, which has 3 set bits.
 *
 * Example 1:
 *
 * Input: nums = [5,10,1,5,2], k = 1
 * Output: 13
 * Explanation: The binary representation of the indices are:
 * 0 = 0002
 * 1 = 0012
 * 2 = 0102
 * 3 = 0112
 * 4 = 1002
 * Indices 1, 2, and 4 have k = 1 set bits in their binary representation.
 * Hence, the answer is nums[1] + nums[2] + nums[4] = 13.
 */
public class SumIndicesWithKBitSet {
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        return IntStream.range(0, nums.size())
                .filter(index -> isSetBitsCountIsK(index, k))
                .map(nums::get)
                .sum();
    }

    public static boolean isSetBitsCountIsK(int index, int k){
        int count = 0;
        while (index != 0){
            index = index & (index-1);
            count++;
        }
        return count == k;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 10, 1, 5, 2);
        int k = 1;
        System.out.println(sumIndicesWithKSetBits(nums, k));
    }
}
