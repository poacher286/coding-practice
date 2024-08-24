package slidingWindow;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    /**
     * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,1,2]
     * Output: 5
     * Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
     * Example 2:
     *
     * Input: nums = [1,2,1,10]
     * Output: 0
     * Explanation:
     * You cannot use the side lengths 1, 1, and 2 to form a triangle.
     * You cannot use the side lengths 1, 1, and 10 to form a triangle.
     * You cannot use the side lengths 1, 2, and 10 to form a triangle.
     * As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
     * @param nums
     * @return
     */
    public static int largestPerimeter(int[] nums) {
        //sort
        Arrays.sort(nums);
        int twoSideSum = nums[0] + nums[1];
        int maxPerimeter = 0;
        for (int k = 2; k < nums.length; k++) {
            if (twoSideSum > nums[k]) {//valid triangle
                maxPerimeter = Math.max(maxPerimeter, twoSideSum + nums[k]);
            }
            twoSideSum = twoSideSum - nums[k - 2] + nums[k];
        }
        return maxPerimeter;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,4};
        System.out.println(largestPerimeter(nums));
    }

}
