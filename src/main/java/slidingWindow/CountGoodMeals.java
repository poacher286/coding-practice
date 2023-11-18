package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
 *
 * You can pick any two different foods to make a good meal.
 *
 * Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the ith item of food,
 * return the number of different good meals you can make from this list modulo 10^9 + 7.
 *
 * Note that items with different indices are considered different even if they have the same deliciousness value.
 *
 *
 *
 * Example 1:
 *
 * Input: deliciousness = [1,3,5,7,9]
 * Output: 4
 */
public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>(); // key: num, val: ocurrence
        int answer = 0, MOD = 1000000007;
        for (int num : deliciousness) {
            int power = 1;
            for (int i = 0; i <= 21; i++) {// 21 because 2^20 + 2^20 = 2^21, this is largest power we can obtain in this problem.
                if (power >= num && map.containsKey(power - num)) {
                    answer += map.get(power - num);
                    answer %= MOD;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return answer;
    }
}
