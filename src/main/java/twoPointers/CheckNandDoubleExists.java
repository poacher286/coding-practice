package twoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckNandDoubleExists {
    /**
     * Given an array arr of integers, check if there exist two indices i and j such that :
     *
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     *
     *
     * Example 1:
     *
     * Input: arr = [10,2,5,3]
     * Output: true
     * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
     * @param arr
     * @return
     */
    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target && mid != i) {
                    return true;
                }
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static boolean checkExists2(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || set.contains(num / 2)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-20,8,-6,-14,0,-19,14,4};
        System.out.println(checkIfExist(arr));
    }
}
