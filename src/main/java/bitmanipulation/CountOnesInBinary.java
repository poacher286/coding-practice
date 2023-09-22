package bitmanipulation;

public class CountOnesInBinary {
    /**
     *let
     * x = 8   -->  1000  --> power of 2 only have one 1s
     * x-1 = 7 -->  0111
     * x & x-1 ==   0000  --> we get 0
     * <------------------------------
     * Only 1 iteration
     *
     * x = 11   -->  1011
     * x-1 = 10 -->  1010 --> x-1 flips last digit
     * x & x-1 ==    1010
     *
     * x = 10  -->   1010
     * x-1 = 9 -->   0101
     * x & x-1 ==    0000
     * <------------------------------
     * 2 iteration
     *
     * ==> count number of iteration
     * @param x - num
     * @return number of 1s
     */
    public static int count1InBinary(int x){
        int count = 0;
        while (x!=0){
          x = x & (x-1);
          count ++;
        }
        return count;
    }
}
