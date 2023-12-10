package binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a 0-indexed array mountain. Your task is to find all the peaks in the mountain array.
 *
 * Return an array that consists of indices of peaks in the given array in any order.
 *
 * Notes:
 *
 * A peak is defined as an element that is strictly greater than its neighboring elements.
 * The first and last elements of the array are not a peak.
 *
 *
 * Example 1:
 *
 * Input: mountain = [2,4,4]
 * Output: []
 * Explanation: mountain[0] and mountain[2] can not be a peak because they are first and last elements of the array.
 * mountain[1] also can not be a peak because it is not strictly greater than mountain[2].
 * So the answer is [].
 * Example 2:
 *
 * Input: mountain = [1,4,3,8,5]
 * Output: [1,3]
 */
public class FindPeaks {
    public List<Integer> findPeaks(int[] nums) {
        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]){
                li.add(i);
            }
        }
        return li;
    }
}
