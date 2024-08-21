package arryas;

public class KthMissingNumber {
    /**
     * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
     *
     * Return the kth positive integer that is missing from this array.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [2,3,4,7,11], k = 5
     * Output: 9
     * @param arr
     * @param k
     * @return
     */
    public int findKthPositive(int[] arr, int k) {
        for(int num : arr){
            if (num <= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }

    public int findKthPositiveBinarySearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left + k;
    }
}
