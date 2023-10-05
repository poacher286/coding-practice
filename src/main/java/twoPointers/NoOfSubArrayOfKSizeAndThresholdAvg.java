package twoPointers;

/**
 * Given an array of integers arr and two integers k and threshold,
 * return the number of sub-arrays of size k and average greater than or equal to threshold.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * Output: 3
 * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
 */
public class NoOfSubArrayOfKSizeAndThresholdAvg {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int left = 0;
        int right = k;
        int count = sum >= threshold * k ? 1 : 0;

        while (right < arr.length) {
            sum += arr[right++] - arr[left++];//update sum = sum + addright - subtractleft
            if (sum >= threshold * k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3, threshold = 4;
        System.out.println(numOfSubarrays(arr, k, threshold));
    }
}
