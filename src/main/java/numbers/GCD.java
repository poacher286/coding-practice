package numbers;

public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /**
     * return gcd of smallest and largest number
     * @param nums number array
     * @return gcd of smallest and largest number
     */
    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }  if (num >= max) {
                max = num;
            }
        }
        return gcd(min, max);
    }

    public static void main(String[] args) {
        System.out.println(gcd(2,217983653));
    }

}
