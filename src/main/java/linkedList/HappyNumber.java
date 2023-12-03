package linkedList;

public class HappyNumber {
    public static boolean isHappy(int num){
        int slow = num;
        int fast = num;

        do{
            slow = squaredNumber(slow);
            fast = squaredNumber(squaredNumber(fast));
        }while (slow != fast);

        return slow == 1;
    }

    public static int squaredNumber(int num){
        int sum = 0;
        while (num > 0){
            int rem = num % 10;
            sum += rem * rem;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 19;
        System.out.println(isHappy(num));
    }
}
