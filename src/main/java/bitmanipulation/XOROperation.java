package bitmanipulation;

public class XOROperation {
    /**
     * You are given an integer n and an integer start.
     *
     * Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
     *
     * Return the bitwise XOR of all elements of nums.
     *
     * Property --->
     * XOR is self-inverse. This means, any number XOR'ed with itself evaluates to 0. a ^ a = 0.
     * that is why res initialize by 0
     *
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
            res ^= nums[i];
        }
        return res;

    }
}
