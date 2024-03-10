package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
 *
 * The 2D array should contain only the elements of the array nums.
 * Each row in the 2D array contains distinct integers.
 * The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of them.
 *
 * Note that the 2D array can have a different number of elements on each row.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= nums.length
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,1,2,3,1]
 * Output: [[1,3,4,2],[1,3],[1]]
 */
public class Convert1DArrTo2D {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] map = new int[nums.length + 1];
        List<List<Integer>> ans = new ArrayList<>();
        for (int num : nums) {
            int freq = map[num];

            if (freq == ans.size()){
                ans.add(new ArrayList<>());
            }
            ans.get(freq).add(num);
            map[num]++;
        }
        return ans;
    }
}
