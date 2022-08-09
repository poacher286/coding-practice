package arryas;

import java.util.Arrays;

public class MissingNumber {
    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i<nums.length; i++){
            if (nums[i] != i){
                return i;
            }

        }
        return nums.length;
    }
}
