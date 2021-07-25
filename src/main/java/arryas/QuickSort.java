package arryas;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] arr, int left, int right) {
        int pivot = left + (right - left) / 2;
        int pivotValue = arr[pivot];

        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i] < pivotValue) {
                i++;
            }
            while (arr[j] > pivotValue) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            if (left < i) {
                quickSort(arr, left, j);
            }
            if (right > i) {
                quickSort(arr, i, right);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,
                2,
                2,
                45,
                2,
                3,
                53,
                54,
                52,
                2,
                22,
                56,
                57,
                56
        };
        System.out.println(Arrays.toString(quickSort(nums, 0, nums.length - 1)));
    }
}
