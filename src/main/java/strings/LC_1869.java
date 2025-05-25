package strings;

public class LC_1869 {
    public static boolean checkZeroOnes(String s) {
        int zero = 0;
        int one = 0;
        int currCount = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) currCount++;
            else {
                if (s.charAt(i - 1) == '1') one = Math.max(one, currCount);
                else zero = Math.max(zero, currCount);
                currCount = 1;
            }
        }

        if (s.charAt(s.length() - 1) == '1') one = Math.max(one, currCount);
        else zero = Math.max(zero, currCount);
        return one > zero;
    }

    public static void main(String[] args) {
//        String s = "1101";
//        String s = "111000";
        String s = "011000111";
        System.out.println(checkZeroOnes(s));
    }
}
