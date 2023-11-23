package arryas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.
 *
 * For example, these are arithmetic sequences:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic:
 *
 * 1, 1, 2, 5, 7
 * You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.
 *
 * Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 * Output: [true,false,true]
 */
public class FindArithmaticSubArray {
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int left = l[i];
            int right = r[i];

            int[] ofRange = Arrays.copyOfRange(nums, left, right + 1);
            if(checkArith(ofRange)){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }

    private static boolean checkArith(int[] ofRange) {
        Arrays.sort(ofRange);
        int d = ofRange[1] - ofRange[0];
        for (int i = 2; i < ofRange.length; i++) {
            if (ofRange[i] - ofRange[i - 1] != d){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,5,9,3,7}, l = {0,0,2}, r = {2,3,5};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }
}
