package twoPointers;

import java.util.*;

public class ThreeSum {

    /**
     * Given an integer array nums,
     * return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * <p>
     * Notice that the solution set must not contain duplicate triplets.
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int leftPonter = i+1;
            Set<List<Integer>> triplets = twoSumSorted(leftPonter, nums, a);
            if (!triplets.isEmpty())
                res.addAll(triplets);
        }
        return new ArrayList<>(res);
    }

    public static Set<List<Integer>> twoSumSorted(int leftPointer, int[] numbers, int target) {
        int rightPointer = numbers.length - 1;

        Set<List<Integer>> result = new HashSet<>();
        while (leftPointer < rightPointer) {
            if (numbers[leftPointer] + numbers[rightPointer] + target > 0) {
                rightPointer--;
            } else if (numbers[leftPointer] + numbers[rightPointer] + target < 0) {
                leftPointer++;
            } else {
                List<Integer> tripletSum = new ArrayList<>();
                tripletSum.add(target);
                tripletSum.add(numbers[leftPointer]);
                tripletSum.add(numbers[rightPointer]);

                result.add(tripletSum);
                leftPointer++;
                rightPointer--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] numbers = {-1,0,1,2,-1,-4};
        int[] numbers = {-2,0,1,1,2};
        System.out.println(threeSum(numbers));
    }
}
