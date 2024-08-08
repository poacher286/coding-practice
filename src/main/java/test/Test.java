package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        int[] arr = {1,2};
        int k = 3;
        System.out.println(Arrays.toString(arrange(arr, k)));
    }

    /**
     * i/p = [1,2,3,4,5]
     * k=2
     * o/p = [4,5,1,2,3]
     * @param arr
     * @param k
     * @return
     */
    public static int[] arrange(int[] arr, int k){
        if (k >= arr.length ){
            throw new RuntimeException("K should be less than array length");
        }
        else if (k==0){
            return arr;
        }
        else if(k < 0){
            throw new RuntimeException("K should be greater than 0");
        }
        int[] newArr = new int[arr.length];
        int idx = 0;
        for (int i=k+1; i<arr.length; i++){
            newArr[idx++] = arr[i];
        }

        for (int i = 0; i<=k; i++){
            newArr[idx++] = arr[i];
        }
        return newArr;
    }

    public void rotate(int[] nums, int k) {
        int start = 0; // start pointer
        k = k % nums.length; // middle pointer
        int end = nums.length - 1; // end pointer

        reverse(nums, start, end - k); //  first half of array for reverse {1, 2, 3, 4} => {4, 3, 2, 1}
        reverse(nums, nums.length - k, end); //  second half of array for reverse {5, 6, 7} => {7, 6, 5}
        reverse(nums, start, end); //  third step flip the entire array {4, 3, 2, 1, 7, 6, 5} => {5, 6, 7, 1, 2, 3, 4}
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start++] ^= nums[end--];
        }
    }

}
