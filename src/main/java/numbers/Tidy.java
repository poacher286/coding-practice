package numbers;

public class Tidy {
    public static boolean isTidy(int num) {
        boolean isTidy = true;
        int rem, temp = 10;
        while (num > 0) {
            rem = num % 10;//r=3
            if (rem > temp) {
                isTidy = false;
                break;
            }
            num = num / 10;//n=12
            temp = rem;//t=3
        }
        return isTidy;
    }
}
