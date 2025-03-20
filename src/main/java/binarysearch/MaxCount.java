package binarysearch;

public class MaxCount {
    /**
     * Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
     *
     * In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
     * Note that 0 is neither positive nor negative.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-2,-1,-1,1,2,3]
     * Output: 3
     * Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
     * @param nums
     * @return
     */
    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int left = 0;
        int  right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // Now, 'left' is the index of the first positive number
        int positiveCount = n - left;

        // Find the last negative number using binary search
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Now, 'right' is the index of the last negative number
        int negativeCount = right + 1;

        // Return the maximum count of positive and negative integers
        return Math.max(positiveCount, negativeCount);
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2};
        System.out.println(maximumCount(nums));
    }
}
