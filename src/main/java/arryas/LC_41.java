package arryas;

import java.util.HashSet;
import java.util.Set;

public class LC_41 {
    /**
     * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
     *
     * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,0]
     * Output: 3
     * Explanation: The numbers in the range [1,2] are all in the array.
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        boolean[] positives = new boolean[nums.length + 1];

        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                positives[num] = true;
            }
        }

        for (int firstMissPos = 1; firstMissPos <= nums.length; firstMissPos++){
            if (!positives[firstMissPos]){
                return firstMissPos;
            }
        }

        return nums.length + 1;
    }

    // O(n) space
    public int firstMissingPositiveOn(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int firstMissPos = 1;
        for (int num : nums) {
            if (num > 0){
                set.add(num);
            }
        }

        while (true){
            if (set.contains(firstMissPos)){
                firstMissPos++;
            }else{
                break;
            }
        }

        return firstMissPos;
    }
}
