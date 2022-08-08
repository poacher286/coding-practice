package arryas;

public class BinarySearch {
    /**
     * Given an array of integers nums which is sorted in ascending order, and an integer target,
     * write a function to search target in nums.
     * If target exists, then return its index. Otherwise, return -1.
     *
     * Approach ->
     * using 2 pointer
     * 1 start from begining, 2 start from end , mid
     * iterate over length
     * check if middle element is equal to target
     * if nums[mid] > target
     *      end = mid -1
     *  else
     *      start = mid+1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while (leftPointer <= rightPointer) {//using while loop decreases time
            int mid = leftPointer + (rightPointer - leftPointer) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) rightPointer = mid - 1;
            else leftPointer = mid + 1;
        }
        return -1;
    }
}
