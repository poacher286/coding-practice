package twoPointers;

public class SquareAndSort {

    /**
     * Given an integer array nums sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        int[] ans = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                ans[i--] = nums[left] * nums[left];
                left++;

            } else {
                ans[i--] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}
