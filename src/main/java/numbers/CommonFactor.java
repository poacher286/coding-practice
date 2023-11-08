package numbers;

import java.util.stream.IntStream;

public class CommonFactor {
    public int commonFactors(int a, int b) {
        int c = Math.min(a, b);
        return (int) IntStream.rangeClosed(1, c).boxed().filter(x -> a % x == 0 && b % x == 0).count();
    }
}
