package arryas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 *
 * you may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> intMap = new HashMap<>();

        for (int num : nums) {
            intMap.put(num, intMap.getOrDefault(num, 0) + 1);
        }

        intMap.forEach((key, value) -> {
            if (value > n / 2) {
                ans.add(key);
            }
        });

        return ans.get(0);
    }
}
