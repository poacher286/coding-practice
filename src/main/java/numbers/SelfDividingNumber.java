package numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * A self-dividing number is not allowed to contain the digit zero.
 *
 * Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].
 *
 *
 *
 * Example 1:
 *
 * Input: left = 1, right = 22
 * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 * Example 2:
 *
 * Input: left = 47, right = 85
 * Output: [48,55,66,77]
 */
public class SelfDividingNumber {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        return IntStream.rangeClosed(left, right)
                .boxed()
                .filter(x -> isSelfDivide(x))
                .collect(Collectors.toList());
    }

    public static boolean isSelfDivide(int num){
        int temp = num;
        while (num != 0){
            int rem = num % 10;
            num = num / 10;
            if (rem == 0){
                return false;
            }
            if (temp % rem != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int left = 47, right = 85;
        System.out.println(selfDividingNumbers(left, right));
    }
}
