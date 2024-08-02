package arryas;

import java.util.Arrays;

public class CountSenior {
    public static int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(x -> {
//            String substring = x.split("[M,F]")[1].substring(0, 2);
            String substring = x.substring(x.length() - 4, x.length() - 2);
            return Integer.parseInt(substring) > 60;
        }).count();
    }

    public static void main(String[] args) {
//        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
//        String[] details = {"1313579440F2036","2921522980M5644"};
        String[] details = {"5612624052M0130","5378802576M6424","5447619845F0171","2941701174O9078"};
        System.out.println(countSeniors(details));
    }
}
