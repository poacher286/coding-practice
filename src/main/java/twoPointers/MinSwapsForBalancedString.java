package twoPointers;

public class MinSwapsForBalancedString {

    public static int minSwaps(String s) {
        int open = 0;
        int close = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '['){
                open++;
            }else{
                close++;
            }

            if (close > open){
                open++;
                close--;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(minSwaps(s));
    }
}
