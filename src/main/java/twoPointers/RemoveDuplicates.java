package twoPointers;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int left = 0;
        int right = 1;
        while (left < nums.length && right < nums.length) {
            if (nums[left] == nums[right]) right++;
            else nums[++left] = nums[right];
        }
        return left + 1;
    }
}
