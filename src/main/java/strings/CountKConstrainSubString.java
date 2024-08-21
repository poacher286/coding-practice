package strings;

public class CountKConstrainSubString {
    public static int countKConstraintSubstrings(String s, int k) {
        int countSubString = 0;
        for(int i = 0; i < s.length(); i++){
            int countZero = 0, countOne = 0 ;
            for(int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }

                if (countZero <= k || countOne <= k) {
                    countSubString++;
                }
            }
        }
        return countSubString;
    }

    public static void main(String[] args) {
        String s = "10101";
        int k = 1;
        System.out.println(countKConstraintSubstrings(s, k));
    }
}
