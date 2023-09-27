package numbers;

import java.util.stream.IntStream;

public class SumOfNumsDivisibleBy357 {
    public static int sumOfMultiples(int n) {
        return IntStream.range(1, n + 1)
                .filter(x -> isDivisibleBy357(x))
                .reduce(0, Integer::sum);
    }

    private static boolean isDivisibleBy357(int x) {
        return x % 3 == 0 || x % 5 == 0 || x % 7 == 0;
    }

    //-----------------------------------
    public int sumOfMultiplesRecursion(int n) {
        return n == 0 ? 0 :
                (n % 3 == 0 || n % 5 == 0 || n % 7 == 0) ? n + sumOfMultiplesRecursion(n - 1) : sumOfMultiplesRecursion(n - 1);
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(sumOfMultiples(n));
    }
}
