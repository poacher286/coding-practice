package memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a target sum
 * Find out if this target sum possible with the element of an Array of numbers
 */
public class CanSum {
    //Normal approach
    //O(m^n)
    //where m = target sum and n = length of an array
    public static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int num : numbers) {
            int rem = targetSum - num;
            if (canSum(rem, numbers))
                return true;
        }
        return false;
    }

    //Memoization O(m*n)
    private static final Map<Integer, Boolean> memo = new HashMap<>(); // creating memo for caching
    public static boolean canSumOptimize(int targetSum, int[] numbers) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int num : numbers) {
            int rem = targetSum - num;
            if (canSumOptimize(rem, numbers)){
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    //tested with java8 stream
    public static boolean canSumWithStream(int targetSum, int[] numbers){
        for (int num : numbers) {
            int rem = targetSum - num;
            return Arrays.stream(numbers)
                    .parallel()
                    .filter(x -> canSum(rem, numbers)).findFirst().isPresent();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSumWithStream(300, new int[]{2,
                1,
                3}));
    }
}
