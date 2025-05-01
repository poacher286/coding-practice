package test;

public class PracticeProblem2 {
    /**
     * Write a program that will calculate the number of trailing zeros in a factorial of a given number.
     *
     * N! = 1 * 2 * 3 *  ... * N
     *
     * Be careful 1000! has 2568 digits...
     */
    public static int trailingZeros(int num){
        //num 2,5 10
        //5 --> 1
        //10 = 10 x 9 x ... x 5 x ... x 2 x 1 --> 2
        //15 --> 3
        //20 --> 4
        //25 --> 25x...x20x...15...10...5...1
        //25 -->6
        int res = 0;
        for (int i = 5; i <= num; i = i*5){
            res += num / i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeros(5));
        System.out.println(trailingZeros(10));
        System.out.println(trailingZeros(25));
        System.out.println(trailingZeros(50));
    }
}
