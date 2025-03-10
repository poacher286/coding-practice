package test;

public class Biweekly150 {
    /**
     * Given an array of integers nums and an integer k, an element nums[i] is considered good
     * if it is strictly greater than the elements at indices i - k and i + k (if those indices exist).
     * If neither of these indices exists, nums[i] is still considered good.
     *
     * Return the sum of all the good elements in the array.
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,2,1,5,4], k = 2
     *
     * Output: 12
     *
     * Explanation:
     *
     * The good numbers are nums[1] = 3, nums[4] = 5, and nums[5] = 4 because they are strictly greater than the numbers at indices i - k and i + k.
     *
     * Example 2:
     *
     * Input: nums = [2,1], k = 1
     *
     * Output: 2
     *
     * Explanation:
     *
     * The only good number is nums[0] = 2 because it is strictly greater than nums[1].
     * @param nums
     * @param k
     * @return
     */
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            if (i - k < 0){
                if (nums[i] > nums[i + k]){
                    sum += nums[i];
                }
            }else if (i + k > nums.length - 1){
                if (nums[i] > nums[i - k]){
                    sum += nums[i];
                }
            }else{
                if (nums[i] > nums[i + k] && nums[i] > nums[i - k]){
                    sum += nums[i];
                }
            }
        }
        return sum;
    }
}
