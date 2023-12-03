package arryas;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];

        int i = 0;//for left
        int j = 0;//for right
        int k = 0;//for mix
        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                mix[k++] = left[i++];
            }else {
                mix[k++] = right[j++];
            }
        }

        //after loop if any one is non empty then assign them in mix
        //only one of these will execute
        while (i < left.length){
            mix[k++] = left[i++];
        }

        while (j < right.length){
            mix[k++] = right[j++];
        }

        return mix;
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

        System.out.println(Arrays.toString(mergeSort(nums)));
    }
}
