package twoPointers;

public class TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining.
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;

        int left_max = 0, right_max = 0;

        while (left < right){
            if (height[left] < height[right]){
                if (height[left] >= left_max){
                    left_max = height[left];
                }else{
                    res += (left_max - height[left]);
                }
                left++;
            }else {
                if (height[right] >= right_max){
                    right_max = height[right];
                }else{
                    res += (right_max - height[right]);
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
