package test;

import java.util.List;

public class WeeklyContest426 {
    /**
     * You are given a positive number n.
     *
     * Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits.
     *
     * A set bit refers to a bit in the binary representation of a number that has a value of 1.
     *
     *
     */
    public static int smallestNumber(int n) {
        int x = n + 1;
        while(true){
            if (isPowerOfTwo(x)){
                return x - 1;
            }
            x = x + 1;
        }
    }

    public static boolean isPowerOfTwo(int x){
        return x != 0 && (x & x-1) == 0;
    }

    public static void main(String[] args) {
        int n = 514;
        System.out.println(smallestNumber(n));
    }
}
