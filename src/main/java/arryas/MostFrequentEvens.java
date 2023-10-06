package arryas;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return the most frequent even element.
 *
 * If there is a tie, return the smallest one. If there is no such element, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,2,4,4,1]
 * Output: 2
 * Explanation:
 * The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
 * We return the smallest one, which is 2.
 */
public class MostFrequentEvens {
    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> fr = new TreeMap<>();
        int maxFr = 0;
        for(int num : nums) {
            if ((num & 1) == 0) {
                fr.put(num, fr.getOrDefault(num, 0) + 1);
                maxFr = Math.max(maxFr, fr.get(num));
            }
        }
        final int finalMaxFr = maxFr;
        return fr.keySet().stream().filter(n -> fr.get(n) == finalMaxFr).findFirst().orElse(-1);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,4,4,1};
//        int[] nums = {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};
        System.out.println(mostFrequentEven(nums));
    }
}
