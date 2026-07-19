package stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    /**
     * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
     * <p>
     * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
     * <p>
     * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
     * <p>
     * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
     * <p>
     *
     *
     * Example 1:
     * <p>
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [-1,3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
     * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();//map to store next grater element in num2
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {//update map if you see next greater ele
                map.put(stack.pop(), num);//update
            }
            stack.push(num);
        }

        return Arrays.stream(nums1)//iterate num1
                .map(x -> map.getOrDefault(x, -1))//find next greater ele in map
                .toArray();
    }
}
