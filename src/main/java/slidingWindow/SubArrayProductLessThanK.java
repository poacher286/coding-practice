package slidingWindow;

/**
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 */
public class SubArrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int prod = 1;
        int ans = 0;
        for (; right < nums.length; right++){
            //right operation
            prod *= nums[right];
            for(; left <= right && prod >= k; left++){
                //left operation
                prod /= nums[left];
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
