package numbers;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
    /**
     * Simplified fraction is fraction between 0-1 where denominator is less than provided number
     *  the number should not be divisible by each other so checked GCD==1
     * @param n - number
     * @return list of simplefied fraction
     */
    public static List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= n; j++) {
                if ((GCD.gcd(i, j) == 1) && i<=j) {
                    res.add(i + "/" + j);
                }
            }
        }
        return res;
    }

}
