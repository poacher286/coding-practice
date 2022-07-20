package bitmanipulation;

public class PowerOfTwo {
    /**
     * x = 8 -->    1000
     * x-1 = 7 -->  0111
     * x & x-1 ==   0000
     *
     * x = 5 -->    0101
     * x-1 = 4 -->  0100
     * x & x-1 ==   0100
     *
     * @param x - num
     * @return true if num is power of 2
     */
    public static boolean isPowerOfTwo(int x){
        return x != 0 && (x & x-1) == 0;
    }

}
