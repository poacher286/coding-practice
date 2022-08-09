package arryas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndex {
    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> lsTarget = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int n = nums[i];
            if (n == target)
                lsTarget.add(i);
        }
        return lsTarget;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,2,3};
        int target = 2;
        System.out.println(targetIndices(nums, target));
    }
}
