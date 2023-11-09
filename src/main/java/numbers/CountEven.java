package numbers;

import java.util.stream.IntStream;

public class CountEven {
    public int countEven(int num) {
        return (int)IntStream.rangeClosed(2, num)
                .boxed()
                .filter(x -> (digitSum(x) & 1) == 0)
                .count();
    }

    public static int digitSum(int num){
        int sum = 0;
        while (num > 0){
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }
        return sum;
    }
}
