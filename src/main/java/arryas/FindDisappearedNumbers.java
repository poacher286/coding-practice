package arryas;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of n integers where nums[i] is in the range [1, n],
 return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();

        sortArray(nums);//sort

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != i+1){//check diff = 1
                missing.add(i+1);
            }
        }
        return missing;
    }

    private static void sortArray(int[] nums){
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int correct = nums[i]-1;
            if(correct < nums.length && nums[correct] != nums[i]){
                swap(nums, correct, i);
            }else{
                i++;
            }
        }
    }

    private static void swap(int[] nums, int first, int last){
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }
}

