package binarysearch;

public class BinarySearchUnknownLength {
    public static int binarySearchUnknownLength(int[] nums, int target){
        //can't use nums.length
        int left = 0;
        int right = 1;
        //find range of left and right where target must be
        while (nums[right] < target) {
            left = right;
            right *= 2;
        }

        //binart serach in between left and right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }
}
