package slidingWindow;

/**
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 *
 * A good array is an array where the number of different integers in that array is exactly k.
 *
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 */
public class SubArrayWithKDistinct {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private static int atMostKDistinct(int[] nums, int k){
        int l = nums.length;
        int left = 0;
        int right = 0;
        int[] freq = new int[l + 1];
        int count = 0;
        int res = 0;
        for(; right < l ; right++){
            //right op
            if (freq[nums[right]] == 0){
                count++;
            }
            freq[nums[right]]++;
            for(; count > k ; left++){
                freq[nums[left]]--;
                if (freq[nums[left]] == 0){
                    count--;
                }
            }
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
