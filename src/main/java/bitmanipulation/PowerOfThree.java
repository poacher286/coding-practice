package bitmanipulation;

public class PowerOfThree {
    /**
     *
     * Knowing the limitation of n, we can now deduce that the maximum value of n
     * that is also a power of three is 1162261467. We calculate this as:
     * 3 ^ [log3MaxInt]
     *  =3^[19.56]
     *  =3^19
     *  =1162261467
     *
     *  herefore, the possible values of n where we should return true are 3^03
     * 0
     *  , 3^13
     * 1
     *   ... 3^{19}3
     * 19
     *  . Since 3 is a prime number, the only divisors of 3^{19}3
     * 19
     *   are 3^03
     * 0
     *  , 3^13
     * 1
     *   ... 3^{19}3
     * 19
     *  , therefore all we need to do is divide 3^{19}3
     * 19
     *   by n. A remainder of 0 means n is a divisor of 3^{19}3
     * 19
     *   and therefore a power of three.
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0; // WTH
    }
}
