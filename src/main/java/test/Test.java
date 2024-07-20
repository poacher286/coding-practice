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

}
