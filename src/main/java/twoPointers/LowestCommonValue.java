package twoPointers;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> ele = new HashSet<>();
        for (int num1 : nums1) {
            ele.add(num1);
        }
        for (int num2 : nums2) {
            if (ele.contains(num2)){
                return num2;
            }
        }
        return -1;
    }

    public int getCommonTwoPointer(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;
        while (first < nums1.length && second < nums2.length){
            if (nums1[first] == nums2[second]){
                return nums1[first];
            }else if(nums1[first] < nums2[second]){
                first++;
            }else{
                second++;
            }
        }
        return -1;
    }
}
