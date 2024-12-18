package arryas;

import java.util.Arrays;

public class ManipulateArray {
    public static int[] moveZeroToLast(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] == 0) {//Compare each element if 0 swap with next element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] moveZeroToLast2(int[] arr) {
        //move those elements to fron which are not zero
        //iterate over array and increase right
        //when swap then only increase left value
        int left = 0;
        int right = 0;
        while(right < arr.length){//[0,1,0,3,12] //[1,0,0,3,12]
            if (arr[right] != 0){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
            }
            right++;
        }
        return arr;
    }

    public static int[] moveZeroToFirst(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] == 0) {//Compare each element if 0 swap with previous element
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {
                1,
                3,
                2,
                1,
                0,
                9,
                0,
                9,
                4,
                8
        };
        System.out.println(Arrays.toString(moveZeroToLast(arr)));
        System.out.println(Arrays.toString(moveZeroToFirst(arr)));

    }
}
