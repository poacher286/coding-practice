package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 */
public class CombinationSum {
    private static List<List<Integer>> res= new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        recursion(candidates, 0, target, new ArrayList<>());
        return res;
    }

    public static void recursion(int[] can,int ind,int target,List<Integer> lis){
        if (target==0){
            res.add(new ArrayList<>(lis));
            return ;
        }
        if (target<0)
            return ;
        for(int i=ind;i<can.length;i++){
            lis.add(can[i]);
            recursion(can,i,target-can[i],lis);
            lis.remove(lis.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }
}
