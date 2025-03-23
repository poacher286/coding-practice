package slidingWindow;

public class LC_2348 {
    public long zeroFilledSubarray(int[] nums) {
        int left = 0,right = 0;
        long ans = 0;
        while(right != nums.length){
            if(nums[right] != 0){
                right++;
                left = right;
            }
            else{
                ans += right - left + 1;
                right++;
            }
        }
        return ans;
    }

    public long zeroFilledSubarray2(int[] nums) {
        long ans = 0, nonZero = 0;
        for(int num: nums) {
            if(num != 0) { nonZero = 0;}
            else {
                ++nonZero;
                ans += nonZero;
            }
        }
        return ans;
    }
}
