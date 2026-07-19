package stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class NextGreaterElement2 {
    /**
     * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
     * <p>
     * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
     * <p>
     *
     *
     * Example 1:
     * <p>
     * Input: nums = [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number.
     * The second 1's next greater number needs to search circularly, which is also 2.
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        //since the nums can be duplicate adding in map is not possible (uniqe ele can be added in map key)
        //we can take stack of index
        Stack<Integer> idxStack = new Stack<>();//store index
        int L = nums.length;
        int[] ans = new int[L];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * L; i++) {
            int circularIdx = i % L;
            while (!idxStack.empty() && nums[idxStack.peek()] < nums[circularIdx]) {
                ans[idxStack.pop()] = nums[circularIdx];
            }
            if (i < L) idxStack.push(circularIdx);
        }
        return ans;
    }
}
