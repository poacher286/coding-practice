package arryas;

import java.util.Arrays;

/**
 * Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
 *
 * answer.length == nums.length.
 * answer[i] = |leftSum[i] - rightSum[i]|.
 * Where:
 *
 * leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
 * rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
 * Return the array answer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,4,8,3]
 * Output: [15,1,11,22]
 * Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
 * The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
 */
public class LeftRightSumDiff {

    public static int[] leftRightDifference(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j < i){
                    leftSum += nums[j];
                }else if (j > i){
                    rightSum += nums[j];
                }
            }
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum = rightSum = 0;
        }
        return ans;
    }

    public static int[] leftRightDifference2(int[] nums) {

        int sumOfElement = 0;
        int l = nums.length;
        int[] ans = new int[l];

        //assign incremental sum to array
        for (int i = 0; i < l; i++) {
            ans[i] = sumOfElement;
            sumOfElement += nums[i];
        }

        sumOfElement = 0;

        for (int i = l-1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - sumOfElement);
            sumOfElement += nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,4,8,3};
        System.out.println(Arrays.toString(leftRightDifference2(nums)));
    }
}
