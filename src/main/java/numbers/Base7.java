package numbers;

public class Base7 {
    /**
     * Given an integer num, return a string of its base 7 representation.
     *
     *
     *
     * Example 1:
     *
     * Input: num = 100
     * Output: "202"
     * Example 2:
     *
     * Input: num = -7
     * Output: "-10"
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        //divide num by 7
        //append reminder in string
        //reverse
        //till num > 0
        StringBuilder ans = new StringBuilder();
        int temp = num;
        num = Math.abs(num);
        while (num > 0){
            int rem = num % 7;
            ans.append(rem);
            num /= 7;
        }
        if (temp < 0){
            ans.append('-');
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
//        int num = 100;
        int num = -7;
        System.out.println(convertToBase7(num));
    }
}
