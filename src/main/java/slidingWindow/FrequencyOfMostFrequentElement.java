package slidingWindow;

import java.util.Arrays;

/**
 * The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most k operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 */
public class FrequencyOfMostFrequentElement {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, ans = 0;
        for (long sum = 0; j < nums.length; ++j) {
            // CODE: use A[j] to update state which might make the window invalid
            sum += nums[j];
            for (; sum + k < (long) nums[j] * (j - i +1); ++i) {
                // CODE: update state using A[i]
                sum -= nums[i];
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 5;
        System.out.println(maxFrequency(nums, k));
    }
}
