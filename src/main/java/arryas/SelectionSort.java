package arryas;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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
        System.out.println(Arrays.toString(selectionSort(nums)));
    }
}
