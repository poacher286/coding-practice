package arryas;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 */
public class MedianOfSortedArray {


    public static double getMedianOf2SortedArray(int[] nums1 , int[] nums2){
        int[] nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);

        Arrays.sort(nums3);

        if (nums3.length % 2 == 0) {
            int n1 = nums3[nums3.length/2];
            int n2 = nums3[(nums3.length/2)-1];
            return (n1+n2) / 2.0;
        } else {
            return nums3[nums3.length/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,7};

        System.out.println(getMedianOf2SortedArray(nums1, nums2));
    }
}
