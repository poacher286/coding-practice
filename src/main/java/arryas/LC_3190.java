package arryas;

import java.util.Arrays;

public class LC_3190 {
    public static int minimumOperations(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(x -> x % 3 == 1 || x % 3 == 2).count();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(minimumOperations(nums));

    }

}
