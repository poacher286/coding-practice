package slidingWindow;

/**
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 */
public class MaxXORTwoNumInArray {
    public static int findMaximumXOR(int[] nums) {
        int maxXOR = 0;
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                maxXOR = Math.max(maxXOR, nums[x] ^ nums[y]);
            }
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
    }
}
