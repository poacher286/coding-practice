package arryas;

import java.util.HashSet;
import java.util.Set;

public class LC_532 {
    /**
     * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
     *
     * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
     *
     * 0 <= i, j < nums.length
     * i != j
     * |nums[i] - nums[j]| == k
     * Notice that |val| denotes the absolute value of val.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,1,4,1,5], k = 2
     * Output: 2
     * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     * Although we have two 1s in the input, we should only return the number of unique pairs.
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> dupSet = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                dupSet.add(num);
            }
        }

        if(k == 0){
            return dupSet.size();
        }

        int pairs = 0;
        for(int num : set){
            if(set.contains(num + k)){
                pairs++;
            }
        }
        return pairs;
    }
}
