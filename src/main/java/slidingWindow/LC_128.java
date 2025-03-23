package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LC_128 {
    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     *
     * You must write an algorithm that runs in O(n) time.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
