package binarysearch;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FindSpecialInteger {
    public static int findSpecialInteger(int[] arr) {
        Set<Integer> distinct = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        for (int tar: distinct) {
            int firstIdx = binarySearch(arr, 0, arr.length - 1, tar, true);
            int secIdx = binarySearch(arr, 0, arr.length - 1, tar, false);
            if (secIdx - firstIdx + 1 > arr.length / 4){
                return tar;
            }
        }
        return 0;
    }

    private static int binarySearch(int[] arr, int left, int right, int tar, boolean firstIdx) {
        int idx = 0;
        while (left <= right){
            int mid = left + (right - left) / 2;

            if (arr[mid] < tar){
                left = mid + 1;
            }
            else if (arr[mid] > tar){
                right = mid - 1;
            }
            else {
                idx = mid;
                if (firstIdx){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        System.out.println(findSpecialInteger(arr));
    }
}
