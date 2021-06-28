package memoization;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(100)));
    }

    public static long factorial(long num) {
        if (num < 2) return 1;
        return num * factorial(num - 1);
    }

    public static BigInteger factorial(BigInteger num) {
        if (num.compareTo(BigInteger.TWO) < 0) return BigInteger.ONE;
        return num.multiply(factorial(num.subtract(BigInteger.ONE)));
    }
}
