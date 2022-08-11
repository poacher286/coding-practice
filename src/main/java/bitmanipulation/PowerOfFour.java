package bitmanipulation;

public class PowerOfFour {
    public static boolean isPowerOfFour(int x) {
        return x > 0 && (x & x-1) == 0 && Math.sqrt(x) * Math.sqrt(x) == x;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(2));
        System.out.println(isPowerOfFour(8));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(32));
    }
}
