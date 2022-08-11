package twoPointers;

import java.util.Arrays;

public class Merge2SortedArray {
    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
     * representing the number of elements in nums1 and nums2 respectively.
     *
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     *
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
     * and the last n elements are set to 0 and should be ignored. nums2 has a length of n
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int index = nums1.length - 1;

        // Both p1 and p2 starts from the last non-empty element and moves backwards.
        // index starts from the end of the output array and is used to fill the array from right to left.
        // At each iteration, the values pointed by p1 and p2 are compared and the larger one is moved to the cell pointed by index and the corresponding pointer is decreased.
        // If p2 < 0, then the second array is finished and all elements of the second array are copied. The first array is already in non-decreasing order.
        // Therefore, the loop is finished when p2 becomes less than zero which means the processing of the second array is finished completely.
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[index] = nums1[p1];
                p1--;
            } else {
                nums1[index] = nums2[p2];
                p2--;
            }
            index--;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }
}
