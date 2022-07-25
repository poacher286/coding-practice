package strings;

public class AddBinary {

    /**
     * Add binary as String
     *          1011 -> 11
     *          1000 -> 8
     *         10011 -> 19
     *    0+0 = 0 - carry 0
     *    0+1 = 1 - carry 0
     *    1+1 = 10 -> place 0 carry 1
     *    1+1+1 = 11 -> place 1 carry 1
     * @param b1
     * @param b2
     * @return
     */
    public static String addBinary(String b1, String b2){
        String bSum = "";
        int lengthB1 = b1.length()-1;
        int lengthB2 = b2.length()-1;
        int minLength = Math.min(lengthB1, lengthB2);
        int carry = 0;
        while(minLength >= 0){
            if (b1.charAt(lengthB1) == '0' && b2.charAt(lengthB2) == '0'){
                if (carry==0){
                    bSum += '0';
                }else {
                    bSum += '1';
                    carry--;
                }
            }
            else if (b1.charAt(lengthB1) == '0' && b2.charAt(lengthB2) == '1'){
                if (carry==0){
                    bSum += '1';
                }else {
                    bSum += '0';
//                    carry--;
                }
            }
            else if (b1.charAt(lengthB1) == '1' && b2.charAt(lengthB2) == '0'){
                if (carry==0){
                    bSum += '1';
                }else {
                    bSum += '0';
//                    carry--;
                }
            }
            else if (b1.charAt(lengthB1) == '1' && b2.charAt(lengthB2) == '1'){
                if (carry==0){
                    bSum += '0';
                    carry++;
                }else {
                    bSum += '1';
//                    carry--;
                }
            }
            lengthB1--;
            lengthB2--;
            minLength--;
        }

//        length1 > length2
        while (lengthB1 >=0){
            if (b1.charAt(lengthB1) == '0'){
                if (carry==0){
                    bSum += '0';
                }else {
                    bSum += '1';
                    carry--;
                }
            }
            else if (b1.charAt(lengthB1) == '1'){
                if (carry==0){
                    bSum += '1';
                }else {
                    bSum += '0';
//                    carry--;
                }
            }
            lengthB1--;
        }

//        lengthB1 > lengthB2
        while (lengthB2 >=0){
            if (b2.charAt(lengthB2) == '0'){
                if (carry==0){
                    bSum += '0';
                }else {
                    bSum += '1';
                    carry--;
                }
            }
            else if (b2.charAt(lengthB2) == '1'){
                if (carry==0){
                    bSum += '1';
                }else {
                    bSum += '0';
//                    carry--;
                }
            }
            lengthB2--;
        }

        if (carry == 1) bSum += '1';
        return Reverse.reverseString(bSum);
    }
}
