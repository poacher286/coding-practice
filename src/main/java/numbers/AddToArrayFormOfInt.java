package numbers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInt {
    /**
     * The array-form of an integer num is an array representing its digits in left to right order.
     *
     * For example, for num = 1321, the array form is [1,3,2,1].
     * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
     *
     *
     *
     * Example 1:
     *
     * Input: num = [1,2,0,0], k = 34
     * Output: [1,2,3,4]
     * Explanation: 1200 + 34 = 1234
     * @return
     */
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList<>();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1,2,0,0};
        int k = 34;
        System.out.println(addToArrayForm(num, k));
    }
}
