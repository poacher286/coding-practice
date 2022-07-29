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

}
