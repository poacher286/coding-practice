package numbers;

public class Armstrong {
    public static boolean isArmstrong(int num) {
        int temp = num;
        int reminder;
        int sum = 0;
        int power = String.valueOf(num).length();
        while (num > 0) {
            reminder = num % 10;
            sum = sum + (int) Math.pow(reminder, power);
            num = num / 10;
        }
        return temp == sum;
    }
}
