package arryas;

import java.util.*;

public class IntersectionOfArray {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> lsInt = new HashSet<>();
        for (int x : nums1) {
            for (int y : nums2) {
                if (x == y)
                    lsInt.add(x);
            }
        }
        return lsInt.stream().mapToInt(x->x).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
