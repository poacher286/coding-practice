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
public class SearchInRotatedSortedArray {

    public static int search(int[] a, int k) {
        int pivot = findPivot(a);

        //if pivot = -1 ==> do normal binary search
        if (pivot == -1){
            return binarySearch(a, k, 0, a.length -1);
        }

        //if pivot found you have 2 Ascending sorted array
        if (a[pivot] == k){
            return pivot;
        }

        if (a[0] <= k){
            return binarySearch(a, k, 0, pivot - 1);
        }

        return binarySearch(a, k, pivot + 1, a.length - 1);
    }

    private static int binarySearch(int[] arr, int tar, int left, int right) {
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < tar){
                left = mid + 1;
            }else if (arr[mid] > tar){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int findPivot(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            //1 arr[mid] > arr[mid + 1] ==> return mid
            if (mid < right && arr[mid] > arr[mid + 1]){
                return mid;
            }

            //2 arr[mid] < arr[mid - 1] ==> return mid - 1;
            if (mid > left && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }

            //3 arr[mid] <= arr[left]  ==> right = mid - 1
            if (arr[mid] <= arr[left]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int tar = 0;
        System.out.println(search(arr, tar));
    }
}
