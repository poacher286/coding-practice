package arryas;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) leftSum += nums[i-1];
            totalSum -= nums[i];
            if (leftSum == totalSum) return i;
        }
        return -1;
    }


}
