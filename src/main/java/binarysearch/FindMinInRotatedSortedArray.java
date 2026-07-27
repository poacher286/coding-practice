package binarysearch;

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int L = nums.length;
        int pivot = findPivot(nums);
        //now I have 2 sorted array
        //[0, pivot] and [pivot + 1, nums.length]
        //search in both sorted array
        //if pivot not found whole array is sorted
        if(pivot == -1) return nums[0];
        return nums[pivot + 1];
    }

    private int findPivot(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //if nums[mid] > nums[mid + 1] ==> pivot is mid
            //if nums[mid] < nums[mid - 1] ==> pivot is mid - 1
            if(mid < right && nums[mid] > nums[mid + 1]) return mid;
            if(mid > left && nums[mid] < nums[mid - 1]) return mid - 1;

            if(nums[mid] >= nums[left]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
