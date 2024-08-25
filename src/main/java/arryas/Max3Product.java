package arryas;

import java.util.Arrays;

public class Max3Product {
    public int maximumProduct(int[] nums) {
        //[-9, -8, -7, -4, -3, -2, 1]
        Arrays.sort(nums);
        int n = nums.length - 1;
        int prod1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int prod2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(prod1, prod2);
    }
}
