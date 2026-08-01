package slidingWindow;

import java.util.List;

public class MaxSubarrayProductSizeK {
    /**
     * max subarray product size k
     * Write a method that takes in a List of numbers and a size k as arguments. The method should return the maximum product of subarrays that contain exactly k elements.
     *
     * You can assume that k is less than or equal to the length of the input List.
     *
     * You can assume that numbers of the List are non-zero.
     */

    public static double maxSubarrayProductSizeK(List<Double> nums, int k) {
        int left = 0;
        int right = 0;
        double maxProduct = 1;
        while (right < k) {
            maxProduct *= nums.get(right++);
        }
        double currentProd = maxProduct;
        while (right < nums.size()) {
            currentProd = currentProd * nums.get(right++) / nums.get(left++);
            maxProduct = Math.max(maxProduct, currentProd);
        }
        return maxProduct;
    }
}
