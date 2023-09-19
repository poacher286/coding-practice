package arryas;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        List<Integer> l = new ArrayList<>();

        for (int n : arr) {
            l.add(n);
            if (n == 0) l.add(0);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = l.get(i);
        }
    }
}
