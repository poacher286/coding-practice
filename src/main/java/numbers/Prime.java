package numbers;

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
}
