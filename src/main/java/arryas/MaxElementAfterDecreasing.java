package arryas;

import java.util.Arrays;

public class MaxElementAfterDecreasing {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        for(int n : arr) {
            max = Math.min(max + 1, n);
        }
        return max;
    }
}
