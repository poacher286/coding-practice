package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubSets {
    /**
     * for i = 0 to i < 2^n
     * for j = 0 to j < n
     * if jth bit of i is 1
     * add in string
     *
     * @param a
     * @param n
     * @return
     */
    public static List<String> possibleSubSet(char[] a, int n) {
        List<String> setList = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) s += a[j];
            }
            setList.add(s);
        }
        return setList;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i< (1 << nums.length); i++){
            List<Integer> subsetList = new ArrayList<>();
            for (int j = 0;  j < nums.length; j++){
                if ((i & (1 << j)) == 0){
                    subsetList.add(nums[j]);
                }
            }
            ansList.add(subsetList);
        }
        return ansList;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(subsets(nums));
    }

}
