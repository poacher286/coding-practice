package bitmanipulation;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 *
 * Return the array after sorting it.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [0,1,2,3,4,5,6,7,8]
 * Output: [0,1,2,4,8,3,5,6,7]
 * Explantion: [0] is the only integer with 0 bits.
 * [1,2,4,8] all have 1 bit.
 * [3,5,6] have 2 bits.
 * [7] has 3 bits.
 * The sorted array by bits is [0,1,2,4,8,3,5,6,7]
 */
public class SortByBits {
    public static int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted()
                .sorted((x, y) -> count1s(x).compareTo(count1s(y)))
                .mapToInt(x -> x)
                .toArray();

    }

    public static Integer count1s(int num){
        int count  = 0;
        while (num != 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
//        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

}
