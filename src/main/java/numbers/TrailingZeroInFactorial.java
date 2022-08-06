package numbers;

public class TrailingZeroInFactorial {
    public static int trailingZeroInfactorial(int n ){
        int res = 0;
        for (int i = 5; i <=n ; i *= 5) {
            res += n/i;
        }
        return res;
    }
}
