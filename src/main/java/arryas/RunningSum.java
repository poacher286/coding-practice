package arryas;

public class RunningSum {
    /**
     * Input: nums = [1,2,3,4]
     * Output: [1,3,6,10]
     * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4]
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        int sum = nums[0];
        runningSum[0] = nums[0];
        for(int i=1; i< nums.length; i++){
            sum += nums[i];
            runningSum[i]=sum;
        }
        return runningSum;
    }
}
