package test;

import java.util.HashMap;
import java.util.Map;

public class Test4 {
    public static int maxAdjacentDistance(int[] nums) {
        int[] newArr = new int[nums.length * 2];
        System.arraycopy(nums, 0, newArr, 0, nums.length);

        if (nums.length * 2 - nums.length >= 0) {
            System.arraycopy(nums, 0, newArr, nums.length, nums.length * 2 - nums.length);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < newArr.length - 1; i++) {
            ans = Math.max(ans, Math.abs(newArr[i] - newArr[i + 1]));
        }
        return ans;
    }

    public static String findValidPair(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            if (first != second && countMap.get(first) == Character.getNumericValue(first)
                    && countMap.get(second) == Character.getNumericValue(second)) {
                return "" + first + second;
            }
        }

        return "";
    }

    public static boolean check(int[] nums) {
        int deepCount = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]){
                deepCount++;
            }
            if (deepCount > 1) {
                return false;
            }
        }
        return true;
    }
}
