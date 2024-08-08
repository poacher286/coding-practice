package memoization;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(100)));
        System.out.println(factorialMemo(10, new HashMap<>()));
        System.out.println(factorialMemo(20, new HashMap<>()));
        System.out.println(factorial(20));
    }

    public static long factorial(long num) {
        if (num < 2) return 1;
        return num * factorial(num - 1);
    }

    public static BigInteger factorial(BigInteger num) {
        if (num.compareTo(BigInteger.TWO) < 0) return BigInteger.ONE;
        return num.multiply(factorial(num.subtract(BigInteger.ONE)));
    }


    public static long factorialMemo(long num, Map<Long, Long> memo){
        if (memo.containsKey(num)){
            return memo.get(num);
        }
        if(num < 2){
            return 1;
        }
        memo.put(num, num * factorialMemo(num - 1, memo));
        return memo.get(num);
    }
}
