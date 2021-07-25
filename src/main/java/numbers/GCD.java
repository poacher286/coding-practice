package numbers;

public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(5, 10));
        System.out.println(gcd(5, 7));
        System.out.println(gcd(5, 25));
    }
}
