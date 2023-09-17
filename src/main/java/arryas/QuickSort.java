package arryas;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] arr, int left, int right) {
        int pivot = left + (right - left) / 2;
        int pivotValue = arr[pivot];

        int left_pointer = left;
        int right_pointer = right;
        while (left_pointer <= right_pointer) {
            while (arr[left_pointer] < pivotValue) {
                left_pointer++;
            }
            while (arr[right_pointer] > pivotValue) {
                right_pointer--;
            }
            if (left_pointer <= right_pointer) {
                int temp = arr[left_pointer];
                arr[left_pointer] = arr[right_pointer];
                arr[right_pointer] = temp;
                left_pointer++;
                right_pointer--;
            }
            if (left < left_pointer) {
                quickSort(arr, left, right_pointer);
            }
            if (right > left_pointer) {
                quickSort(arr, left_pointer, right);
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
