package twoPointers;

import java.util.Arrays;

public class SortByParity {
        public static int[] sortArrayByParity(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                if ((nums[left] & 1) == 0) left++;
                else if ((nums[right] & 1) !=0) right--;
                else if ((nums[left] & 1) > (nums[right] & 1)){ // left side will give odd (1) and will be greater that (0)
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
            }
            return nums;
        }
    
        public static void main(String[] args) {
            int[] nums = {3,1,2,4};
            System.out.println(Arrays.toString(sortArrayByParity(nums)));
        }
    }