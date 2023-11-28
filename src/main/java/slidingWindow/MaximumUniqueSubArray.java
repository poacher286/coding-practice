package slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
 *
 * Return the maximum score you can get by erasing exactly one subarray.
 *
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 */
public class MaximumUniqueSubArray {
    public static int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxSum = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (; right < nums.length; right++){
            //right operation
            sum += nums[right];
            for (; !set.add(nums[right]); left++){
                //left operation
                sum -= nums[left];
                set.remove(nums[left]);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }
}
