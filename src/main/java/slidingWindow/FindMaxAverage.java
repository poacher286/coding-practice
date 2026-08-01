package slidingWindow;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxSum = 0;
        while(right < k){
            maxSum += nums[right++];
        }
        int currSum = maxSum;
        while(right < nums.length){
            currSum += nums[right++] - nums[left++];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum * 1.0 / k;
    }
}
