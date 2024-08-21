package slidingWindow;

public class FindPowerOfKSizeSubArray {

    /**
     * You are given an array of integers nums of length n and a positive integer k.
     *
     * The power of an array is defined as:
     *
     * Its maximum element if all of its elements are consecutive and sorted in ascending order.
     * -1 otherwise.
     * You need to find the power of all
     * subarrays
     *  of nums of size k.
     *
     * Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4,3,2,5], k = 3
     *
     * Output: [3,4,-1,-1,-1]
     * @param nums
     * @param k
     * @return
     */
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];

        // Check the first window manually
        boolean isSortedAndConsecutive = true;
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                isSortedAndConsecutive = false;
                break;
            }
        }

        // Store result for the first window
        results[0] = isSortedAndConsecutive ? nums[k - 1] : -1;

        // Process the rest of the windows using sliding window
        for (int i = 1; i <= n - k; i++) {
            // Check if the current window remains sorted and consecutive
            if (isSortedAndConsecutive && nums[i + k - 1] == nums[i + k - 2] + 1) {
                // If the previous window was valid and the new element continues the sequence
                results[i] = nums[i + k - 1];
            } else {
                // Recheck the entire window
                isSortedAndConsecutive = true;
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] != nums[j - 1] + 1) {
                        isSortedAndConsecutive = false;
                        break;
                    }
                }
                results[i] = isSortedAndConsecutive ? nums[i + k - 1] : -1;
            }
        }

        return results;

    }
}
