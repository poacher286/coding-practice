package slidingWindow.atmostPattern;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

    public int subarraysWithKDistinct2(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k - 1);
    }

    public int atmost(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int noOfSubarrray = 0;
        for (int num : nums) {
            //right operation
            //each subarray should have atleast k elements
            set.add(num);
            queue.offer(num);

            while (set.size() > k) {
                int removed = queue.poll();
                if (!queue.contains(removed)) set.remove(removed);
            }
            noOfSubarrray += queue.size();
        }
        return noOfSubarrray;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
