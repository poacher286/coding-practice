package arryas;

public class CanBeIncreasing {
    /**
     * Given a 0-indexed integer array nums, return true if it can be made strictly increasing after removing exactly one element, or false otherwise. If the array is already strictly increasing, return true.
     *
     * The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length).
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,10,5,7]
     * Output: true
     * When we find a drop, we check if the current number nums[i] is greater than the number before the previous one nums[i - 2].
     *
     * If so, the number nums[i - 1] needs to be removed.
     * Otherwise, the current number needs to be removed (nums[i]).
     * For simplicity, I just assign the previous value to the current number (nums[i] = nums[i - 1]).
     * And, of course, we return false if we find a second drop.
     * @param nums
     * @return
     */
    public static boolean canBeIncreasing(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i] <= nums[i - 1]) {
                count++;
                if(i > 1 && nums[i] <= nums[i - 2]){
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count < 2;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,10,5,7};
        System.out.println(canBeIncreasing(nums));
    }
}
