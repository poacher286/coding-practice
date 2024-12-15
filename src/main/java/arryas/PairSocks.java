package arryas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSocks {
    /**
     * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
     *
     * Example
     *
     *
     * There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
     *
     * Function Description
     *
     * Complete the sockMerchant function in the editor below.
     *
     * sockMerchant has the following parameter(s):
     *
     * int n: the number of socks in the pile
     * int ar[n]: the colors of each sock
     * Returns
     *
     * int: the number of pairs
     * @param n
     * @param ar
     * @return
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : ar){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int pair = 0;
        for(int val : freq.values()){
            pair += val / 2;
        }
        return pair;
    }
}
