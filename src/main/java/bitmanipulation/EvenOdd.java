package bitmanipulation;

public class EvenOdd {
    /**
     * if x = 5 --> x = 101
     * 101 AND 001 = 001
     * x = 6 --> x = 110
     * 110 AND 001 = 000
     *
     * Property - last digit of any even number is always 0 when converted to binary
     * @param x - number
     * @return true if number is even
     */
    public static boolean isEven(int x){
        return (x & 1) == 0;
    }
}
