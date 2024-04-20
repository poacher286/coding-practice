package numbers;

public class SumOfDigitsOfString {
    /**
     * You are given a string s consisting of lowercase English letters, and an integer k.
     *
     * First, convert s into an integer by replacing each letter with its position in the alphabet
     * (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, transform the integer by replacing it with the sum of its digits.
     * Repeat the transform operation k times in total.
     *
     * For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:
     *
     * Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
     * Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
     * Transform #2: 17 ➝ 1 + 7 ➝ 8
     * Return the resulting integer after performing the operations described above.
     * @param s
     * @param k
     * @return
     */
    public static int getLucky(String s, int k) {
        String num = "";
        for (char c : s.toCharArray()){
            num += (c - 'a' + 1);
        }
        for (int i = 0; i < k; i++){
            int sum = 0;
            while (num.length() > 0){
                sum += num.charAt(num.length() - 1) - '0';
                num = num.substring(0, num.length() - 1);
            }
            num = String.valueOf(sum);
        }
        return Integer.parseInt(num);
    }

    public static void main(String[] args) {
        String s = "zbax";
        int k = 2;
        System.out.println(getLucky(s, k));
    }
}
