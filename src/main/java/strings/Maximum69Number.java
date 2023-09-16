package strings;

public class Maximum69Number {

    public static int maximum69Number(int num) {
        String s = String.valueOf(num);
        char[] digits = s.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        int test = 9999;
        System.out.println(maximum69Number(test));
    }
}
