package slidingWindow;

public class MinOperationToMakeArrayOne {
    /**
     * You are given a binary array nums.
     *
     * You can do the following operation on the array any number of times (possibly zero):
     *
     * Choose any 3 consecutive elements from the array and flip all of them.
     * Flipping an element means changing its value from 0 to 1, and from 1 to 0.
     *
     * Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,1,1,0,0]
     *
     * Output: 3
     *
     * Explanation:
     * We can do the following operations:
     *
     * Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
     * Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
     * Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
     * Example 2:
     *
     * Input: nums = [0,1,1,1]
     *
     * Output: -1
     *
     * Explanation:
     * It is impossible to make all elements equal to 1.
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int count = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i - 2] == 0){
                count++;
                nums[i - 2] ^= 1;
                nums[i - 1] ^= 1;
                nums[i] ^= 1;
            }
        }

        int sum = 0;//check if all num == 1
        for (int num : nums){
            sum += num;
        }

        return sum == nums.length ? count : -1;
    }

    public int minOperations2(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n - 2; i++){
            if(nums[i] == 0){
                count++;
                nums[i + 2] ^= 1;
                nums[i + 1] ^= 1;
                nums[i] ^= 1;
            }
        }
        //iterate through 0 to len - 3
        //perform operation
        //after check id last 2 is 0 or not
        //if any of them are 0 then return -1
        return (nums[n - 1] == 0 || nums[n - 2] == 0) ? -1 : count;
    }
}
