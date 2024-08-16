package slidingWindow;

import java.util.*;

public class LongestSubArray {
    /**
     * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
     * Given an array of integers nums and an integer limit,
     * return the size of the longest non-empty subarray such that
     * the absolute difference between any two elements of this subarray is less than or equal to limit.
     *
     * More specifically,
     * use the two pointer technique,
     * moving the right pointer as far as possible to the right until the subarray is not valid
     * (maxValue - minValue > limit), then moving the left pointer until the subarray is valid again
     * (maxValue - minValue <= limit). Keep repeating this process.
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int best = 0;

        LinkedList<Integer> incDQ = new LinkedList<>();
        LinkedList<Integer> decDQ = new LinkedList<>();

        for(; right < nums.length; right++){
            //right operation
            while(!incDQ.isEmpty() && incDQ.getLast() > nums[right]){
                incDQ.removeLast();
            }
            while(!decDQ.isEmpty() && decDQ.getLast() < nums[right]){
                decDQ.removeLast();
            }
            incDQ.add(nums[right]);
            decDQ.add(nums[right]);

            //moving the left pointer until the subarray is valid again
            //first element of decDQ is max
            //first element of incDQ is min
            while (decDQ.getFirst() - incDQ.getFirst() > limit){//window invalid
                //remove nums[left] from each DQ if that is first element
                //increase left pointer
                if (decDQ.getFirst() == nums[left]) {
                    decDQ.removeFirst();
                }
                if (incDQ.getFirst() == nums[left]) {
                    incDQ.removeFirst();
                }
                left++;
            }
            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    //Exceeding time limit
    public int longestSubarrayUsingSortedList(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        List<Integer> sortedList = new ArrayList<>();

        int best = 0;

        for(; right < nums.length; right++){
            sortedList.add(nums[right]);
            Collections.sort(sortedList);
            while(sortedList.get(sortedList.size() - 1) - sortedList.get(0) > limit){
                sortedList.remove((Integer) nums[left]);
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    public static void main(String[] args) {
//        int[] nums = {8,2,4,7};
//        int limit = 4;
        int[] nums = {2,2,2,4,4,2,5,5,5,5,5,2};
        int limit = 2;
        System.out.println(longestSubarray(nums, limit));
    }
}
