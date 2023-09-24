package arryas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumOddLengthSubArray {
    public static int sumOddLengthSubarrays(int[] arr) {
        List<List<Integer>> collect = getSubArray(arr).stream()
                .filter(x -> (x.size() & 1) != 0)
                .collect(Collectors.toList());

        int sum = 0;
        for (List<Integer> oddList : collect) {
            for (int num : oddList) {
                sum += num;
            }
        }
        return sum;
    }

    /**
     * A subarray is a contiguous subsequence of the array.
     * @param arr
     * @return
     */
    public static List<List<Integer>> getSubArray(int[] arr) {
        List<List<Integer>> subArrayList = new ArrayList<>();
        List<Integer> subArray;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                subArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArray.add(arr[k]);
                }
                subArrayList.add(subArray);
            }
        }
        return subArrayList;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));
    }
}
