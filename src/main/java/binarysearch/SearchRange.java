package binarysearch;

public class SearchRange {
    public static int[] searchRange(int[] arr, int tar){
        int left = 0;
        int right = arr.length - 1;
        int[] ans = new int[2];
        ans[0] = binarySearch(arr, left, right, tar, true);
        ans[1] = binarySearch(arr, left, right, tar, false);
        return ans;
    }

    private static int binarySearch(int[] arr, int left, int right, int tar, boolean firstIdx) {
        int idx = 0;
        while (left < right){
            int mid = left + (right - left) / 2;

            if (arr[mid] < tar){
                left = mid + 1;
            }else if (arr[mid] > tar){
                right = mid - 1;
            }else{
                idx = mid;
                if (firstIdx){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return idx;
    }
}
