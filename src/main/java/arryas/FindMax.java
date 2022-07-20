package arryas;

import java.util.Arrays;

public class FindMax {
    public static int findMax(int[] arr){
        return Arrays.stream(arr)
                .reduce(Integer.MIN_VALUE, Math::max);
    }

    public static int findMin(int[] arr){
        return Arrays.stream(arr)
                .reduce(Integer.MAX_VALUE, Math::min);
    }

    public static void main(String[] args) {
        int[] nums = {
                1,
                2,
                2,
                45,
                2,
                3,
                53,
                54,
                52,
                2,
                22,
                56,
                57,
                56
        };
        System.out.println(findMax(nums));
        System.out.println(findMin(nums));
    }
}
