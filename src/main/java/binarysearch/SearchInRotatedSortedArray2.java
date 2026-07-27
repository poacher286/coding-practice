package binarysearch;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class SearchInRotatedSortedArray2 {

    //Duplicate is allowed
    //shrink the array if duplicate found

    /**
     * Even though the array is rotated, one half is always sorted.
     * <p>
     * For every mid:
     * <p>
     * Either the left half (left..mid) is sorted.
     * Or the right half (mid..right) is sorted.
     */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //[4,5,6,7,0,1,2]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            // Cannot determine the sorted half
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

}
