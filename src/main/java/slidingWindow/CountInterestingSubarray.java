package slidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountInterestingSubarray {
    /**
     * You are given a 0-indexed integer array nums, an integer modulo, and an integer k.
     * <p>
     * Your task is to find the count of subarrays that are interesting.
     * <p>
     * A subarray nums[l..r] is interesting if the following condition holds:
     * <p>
     * Let cnt be the number of indices i in the range [l, r] such that nums[i] % modulo == k. Then, cnt % modulo == k.
     * Return an integer denoting the count of interesting subarrays.
     * <p>
     * Note: A subarray is a contiguous non-empty sequence of elements within an array.     * @param nums
     *
     * @param modulo
     * @param k
     * @return
     */
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);

        long ans = 0;
        int count = 0;

        for (int num : nums) {

            if (num % modulo == k) {
                count++;
            }

            int remainder = count % modulo;

            int required = (remainder - k + modulo) % modulo;

            ans += map.getOrDefault(required, 0L);

            map.put(remainder, map.getOrDefault(remainder, 0L) + 1);
        }

        return ans;
    }
}
