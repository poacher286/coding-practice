package numbers;

/**
 * Given a positive integer n, find the pivot integer x such that:
 *
 * The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
 * Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 8
 * Output: 6
 */
public class PivotElement {
    public static int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            if (sum(1, i) == sum(i, n)){
                return i;
            }
        }
        return -1;
    }

    public static int sum(int begin, int end){
        return (end - begin + 1) * (begin + end) / 2;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }
}
