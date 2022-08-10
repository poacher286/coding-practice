package twoPointers;

import java.util.HashSet;
import java.util.Set;

public class ArithmeticTriplets {

    /**
     * You are given a 0-indexed,
     * strictly increasing integer array nums and a positive integer diff.
     * A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
     *
     *      i < j < k,
     *      nums[j] - nums[i] == diff, and
     *      nums[k] - nums[j] == diff.
     *      Return the number of unique arithmetic triplets.
     * @param nums
     * @param diff
     * @return
     */
    public static int arithmeticTriplets(int[] nums, int diff) {
        int left = 0;
        int right = 1;
        int count = 0;
        Set<Integer> setInt = new HashSet<>();
        for (int n : nums) {
            setInt.add(n);
        }
        while(left <= right && right < nums.length){
            if(nums[right] - nums[left] < diff)
                right++;
            else if(nums[right] - nums[left] >diff)
                left++;
            else {
                if(setInt.contains(nums[right] + diff))
                    count++;
                left++;
                right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,6,7,11};
        int diff = 5;
        System.out.println(arithmeticTriplets(nums, diff));
    }
}
