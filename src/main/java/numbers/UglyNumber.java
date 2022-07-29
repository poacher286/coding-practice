package numbers;

public class UglyNumber {

    public static void main(String[] args) {
//        int n = 3, a = 2, b = 3, c = 5;
//        int n = 4, a = 2, b = 3, c = 4;
        int n = 5, a = 2, b = 11, c = 13;
//        int n = 1000000000, a = 2, b = 217983653, c = 336916467;

        System.out.println(nthUglyNumber(n, a, b, c));
    }

    /**
     * A U B U C = A + B + C - AB - BC - AC + ABC
     *
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = Integer.MAX_VALUE;
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(ab, c);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long count = ((long) mid / a + mid / b + mid / c) - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count >= n) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
