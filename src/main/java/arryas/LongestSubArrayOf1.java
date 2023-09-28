package arryas;

/**
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 *
 *
 * Algorithm
 *
 * Initialize three variables:
 *
 * a. zeroCount to 0; this is the number of zeroes in the current window.
 *
 * b. longestWindow to 0; this is the longest window having at most one 0 we have seen so far.
 *
 * c. start to 0; this is the left end of the window from where it starts.
 *
 * Iterate over the array, and keep counting the zeroes in the variable zeroCount.
 *
 * After every element, check if the zeroCount exceeds 1; if yes, keep removing elements from the left until the value of zeroCount becomes <= 1.
 *
 * Update the variable longestWindow with the current window length, i.e. i - start. Note that this subtraction will give the number of elements in the window minus 1, as we need to delete one element too.
 *
 * Return longestWindow.
 */
public class LongestSubArrayOf1 {
    public static int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int longestWindow = 0;
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++){
            zeroCount += (nums[rightPointer] == 0 ? 1 : 0);

            //while zero > 1 shrink window from left
            //and decrease zero count
            while (zeroCount > 1){
                zeroCount -= (nums[leftPointer++] == 0 ? 1 : 0);
            }

            longestWindow = Math.max(longestWindow, rightPointer - leftPointer);
        }
        return longestWindow;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
}
