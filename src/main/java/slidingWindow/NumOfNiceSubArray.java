package slidingWindow;

/**
 * Given an array of integers nums and an integer k.
 * A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 */
public class NumOfNiceSubArray {
    public static int numberOfSubarrays(int[] nums, int k) {
        return counAtMostK(nums, k) - counAtMostK(nums, k - 1);
    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int counAtMostK(int[] nums, int k){
        int len = nums.length;
        int count = 0;
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < len) {
            if ((nums[right] & 1) == 1) {
                count++;
            }
            while (count > k) {
                if ((nums[left] & 1) == 1) {
                    count--;
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
