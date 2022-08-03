package twoPointers;

import java.util.Arrays;

public class PivotArray {
    /**
     * You are given a 0-indexed integer array nums and an integer pivot.
     * Rearrange nums such that the following conditions are satisfied:
     *
     * Every element less than pivot appears before every element greater than pivot.
     * Every element equal to pivot appears in between the elements less than and greater than pivot.
     * The relative order of the elements less than pivot and the elements greater than pivot is maintained.
     * More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position
     * of the jth element. For elements less than pivot,
     * if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj.
     * Similarly for elements greater than pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.
     * Return nums after the rearrangement.
     * @param nums
     * @param pivot
     * @return
     */
    public static int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left_pointer = 0;
        int right_pointer = nums.length - 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot)
                result[left_pointer++] = nums[i];

            if(nums[nums.length - 1 - i] > pivot)
                result[right_pointer--] = nums[nums.length - 1 - i];
        }

        while(left_pointer <= right_pointer) {
            result[left_pointer++] = pivot;
            result[right_pointer--] = pivot;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        System.out.println(Arrays.toString(pivotArray(nums, pivot)));
    }
}
