package strings;

public class AddString {

    /**
     *          5436
     *          3457
     *      ---------
     *          8893
     * @param b1
     * @param b2
     * @return
     */
    public static String addStrings(String b1, String b2) {
        String bSum = "";
        int lengthB1 = b1.length()-1;
        int lengthB2 = b2.length()-1;
        int carry = 0;

        while (lengthB1 >= 0 || lengthB2 >= 0 || carry>0){
            int v1 = lengthB1 >= 0 ? b1.charAt(lengthB1) - '0' : 0;
            int v2 = lengthB2 >= 0 ? b2.charAt(lengthB2) - '0' : 0;
            int unitDigit;
            unitDigit = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;

            bSum = unitDigit + bSum; // adding bSum to last so we don't have to reverse string
            lengthB1--;
            lengthB2--;
        }

        return bSum;
    }

}
