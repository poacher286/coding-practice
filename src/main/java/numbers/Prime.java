package numbers;

import java.util.Arrays;

public class Prime {
    public static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count == 1;
    }

    public static boolean isPrimeNew(int number) {
        if (number == 2 ||  number == 3) {
            return true;
        }

        // check if n is a multiple of 2
        if (number % 2 == 0) {
            return false;
        }

        // if not, then just check the odds
        for (var i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeNew(i)){
                count++;
            }
        }
        return count;
    }

    /**
     * algorithm Sieve of Eratosthenes is
     *     input: an integer n > 1.
     *     output: all prime numbers from 2 through n.
     *
     *     let A be an array of Boolean values, indexed by integers 2 to n,
     *     initially all set to true.
     *
     *     for i = 2, 3, 4, ..., not exceeding √n do
     *         if A[i] is true
     *             for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n do
     *                 set A[j] := false
     *
     *     return all i such that A[i] is true.
     * @param n
     * @return
     */
    public static int sieveOfEratosthenes(int n) {
        if(n<2) return 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        int count=0;
        for (int p = 2;p < n; p++) {
            if(primes[p])
            {
                count++;
                if((long)p*p<n)
                {
                    for(int i=p*p;i<n;i+=p)
                        primes[i]=false;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(sieveOfEratosthenes(n));
    }

}
