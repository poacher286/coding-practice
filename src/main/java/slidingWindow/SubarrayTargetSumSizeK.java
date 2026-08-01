package slidingWindow;

import java.util.List;

public class SubarrayTargetSumSizeK {
    /**
     * subarray target sum size k
     * Write a method that takes in a List of numbers, a target sum, and a size k as arguments. The method should return the number of subarrays of size k that sum to the target.
     *
     * You can assume that k is less than or equal to the length of the input List.
     */
    public static int subarrayTargetSumSizeK(List<Integer> nums, int target, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while (right < k) {
            sum += nums.get(right++);
        }

        if (nums.size() == k && sum == target) count++;//edge case for k is size of list and sum == target

        while (right < nums.size()) {
            if (sum == target) count++;
            sum += nums.get(right++) - nums.get(left++);
        }
        return count;
    }
}
