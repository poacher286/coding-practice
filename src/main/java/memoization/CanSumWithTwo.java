package memoization;

import java.util.Arrays;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class CanSumWithTwo {
    public static boolean canSumWithTwo(int targetSum , int[] numbers){
        return Arrays.stream(numbers)
                .anyMatch(num ->
                        Arrays.stream(numbers)
                        .filter(x -> x == targetSum - num)
                        .findFirst()
                        .isPresent());
    }

    public static void main(String[] args) {
        System.out.println(canSumWithTwo(15, new int[]{1,
                15,
                3,
                3,
                4,
                5,
                10,
                7,
        3}));
    }

}
