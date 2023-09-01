package twoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountPairs {
    /**
     * 2824. Count Pairs Whose Sum is Less than Target
     * Given a 0-indexed integer array nums of length n and an integer target,
     * return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int countPairs(List<Integer> nums, int target) {
        int count = 0;
        int leftPointer = 0;
        int rightPointer = nums.size() - 1;
        Collections.sort(nums);

        while (rightPointer > leftPointer) {
            if ((nums.get(leftPointer) + nums.get(rightPointer)) < target) {
                count = count + (rightPointer - leftPointer);
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return count;
    }

    public static int countPairs2ForLoop(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (i < j && (nums.get(i) + nums.get(j)) < target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>() {
            {
                add(-1);
                add(1);
                add(2);
                add(3);
                add(1);
            }
        };
        System.out.println(countPairs(numbers, 2));
        System.out.println(countPairs2ForLoop(numbers, 2));
    }
}
