package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    private Map<Integer, Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        /*
        A robber has 2 options: a) rob current house i; b) don't rob current house.
        If an option "a" is selected it means she can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows.
        If an option "b" is selected the robber gets all the possible loot from robbery of i-1 and all the following buildings.
        So it boils down to calculating what is more profitable:

        --robbery of current house + loot from houses before the previous
        --loot from the previous house robbery and any loot captured before that
        rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
         */
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int currentHouse) {
        if (currentHouse < 0) {
            return 0;
        }
        if (memo.containsKey(currentHouse)){
            return memo.get(currentHouse);
        }

        int cumulativeValue = Math.max(rob(nums, currentHouse - 2) + nums[currentHouse], rob(nums, currentHouse - 1));
        memo.put(currentHouse, cumulativeValue);
        return memo.get(currentHouse);
    }
}
