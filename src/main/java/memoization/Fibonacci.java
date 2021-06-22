package memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * creating fibonacci with help of memoization
 */
public class Fibonacci {
    private static final Map<Long, Long> cache = new HashMap<>();

    public static long fibonacci(long num) {
        if (cache.containsKey(num)) //Checking if value present in cache data
            return cache.get(num); // return cache data if present
        if (num <= 2)
            return 1;
        cache.put(num, fibonacci(num - 1) + fibonacci(num - 2));//put value of iteration
        return cache.get(num);//return final number
    }

    public static long normalFib(long n) {
        if (n <= 2)
            return 1;
        return normalFib(n - 1) + normalFib(n - 2);
    }

//    public static void main(String[] args) {
//        System.out.println(fibonacci(50));
//    }

}
