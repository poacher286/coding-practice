package bitmanipulation;

public class CheckIthBitIsOne {

    /**
     * x = 7 -->    0111
     * 1 << 2 -->   0100
     * x & mask --> 0100
     *
     * @param x - number
     * @param i - i th bit
     * @return true if ith bit is 1
     */
    public static boolean checkIthBitIsOne(int x, int i){
        int bitMask = 1 << i;
        return (x & bitMask) != 0 ;
    }
}
