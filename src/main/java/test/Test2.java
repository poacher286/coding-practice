package test;

import java.util.Arrays;

public class Test2 {
    /**
     * Input: {1,2,3,4}//1234
     * Output: {1,2,3,5}
     *
     * Input: {7,8,9}
     * Output: {7,9,0}
     *
     * Input: {9,9,9}
     * Output: {1,0,0,0}
     *
     * Input: {0,0,1,0}
     * Input: {0,0,1,1}
     * @param args
     */
    public static void main(String[] args) {
        int[] inp = {9,9,9};
        System.out.println(Arrays.toString(solve(inp)));
    }

    public static int[] solve(int[] inp){
        int[] op = new int[inp.length];
        int carry = 0;
        int add = 1;
        for (int i = inp.length -1; i>=0; i--){//
            int update = inp[i] + add + carry;
            op[i] = update % 10;
            if((update) >= 10){
                carry = 1;
            }else{
                carry = 0;
            }
            add = 0;
        }
        int[] res = new int[inp.length+1];
        if (carry==1){
            res[0] = carry;
            for (int i=0; i< op.length; i++) {
                res[i+1] = op[i];
            }
        }
        return carry == 1 ? res : op;
    }
}
