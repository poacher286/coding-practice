package slidingWindow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxSumOfDistinctSubarray {
    /**
     * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
     *
     * The length of the subarray is k, and
     * All the elements of the subarray are distinct.
     * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * @param nums
     * @param k
     * @return
     */
    public long maximumSubarraySum(int[] nums, int k) {
        //nums = [1,5,4,2,9,9,9], k = 3
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        long sum = 0;
        long max = 0;
        for (int num : nums){
            //check befor only if num already exist in set
            //remove duplicate from set
            //remove last element from q untill its removed from set
            while (set.contains(num)) {
                int poll = q.poll();
                set.remove(poll);
                sum -= poll;
            }

            //add num to q and set and update sum
            q.offer(num);
            set.add(num);
            sum += num;

            //keep window size at most k
            while (q.size() > k) {
                int poll = q.poll();
                set.remove(poll);
                sum -= poll;
            }

            if (q.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
