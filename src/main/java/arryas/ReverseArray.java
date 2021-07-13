package arryas;

import java.util.Arrays;

public class ReverseArray {

    public static int[] reverseArray(int[] arg) {
        for (int i = 0; i < arg.length / 2; i++) {
            //swap left half to right half
            int temp = arg[i];
            arg[i] = arg[arg.length - 1 - i];
            arg[arg.length - 1 - i] = temp;
        }
        return arg;
    }

    public static void main(String[] args) {
        int[] arr = {
                1,
                3,
                5,
                3,
                6,
                3,
                4
        };
        System.out.println(Arrays.toString(reverseArray(arr)));
    }

}
