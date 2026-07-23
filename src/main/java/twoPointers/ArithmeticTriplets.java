package twoPointers;

import java.util.HashMap;
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

    public int arithmeticTriplets2(int[] nums, int diff) {
        // j - i = diff
        // k - j = diff
        // i = init
        // j = diff + i
        // k = diff + j
        // k = diff + diff + i
        // k = 2 * diff + i

        // for each element (i) find (j) is present or not
        // if present find (k)
        // if (j) and (k) found update counter
        int counter = 0;
        for (int num : nums) {
            if (binarySearch(nums, num + diff) && binarySearch(nums, num + 2 * diff)) {
                counter++;
            }
        }
        return counter;
    }

    public int arithmeticTriplets3(int[] nums, int diff) {
        int counter = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : nums) {
            if (numSet.contains(num + diff) && numSet.contains(num + 2 * diff)) {
                counter++;
            }
        }
        return counter;
    }

    public int arithmeticTriplets4(int[] nums, int diff) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            seen.put(nums[i], i);
        }
        for (int num : nums) {
            if (seen.containsKey(num + diff) && seen.containsKey(num + 2 * diff)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,6,7,11};
        int diff = 5;
        System.out.println(arithmeticTriplets(nums, diff));
    }
}
