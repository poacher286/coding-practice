package slidingWindow;

import java.util.Arrays;

/**
 * You are given an integer array nums and a positive integer k.
 *
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 *
 * A subarray is a contiguous sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 */
public class CountSubArraywithAtleastKtimes {
    public long countSubarrays(int[] arr, int k) {
        int max = Arrays.stream(arr).max().getAsInt();
        int left = 0;
        int right = 0;
        int currMax = 0;
        long res = 0;
        for(; right < arr.length; right++){
            currMax += arr[right] == max ? 1 : 0;
            for(; currMax >= k; left++){
                currMax -= arr[left] == max ? 1 : 0;
            }
            res += left;
        }
        return res;
    }
}
