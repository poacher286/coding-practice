package numbers;

import java.util.stream.IntStream;

public class Palindrome {
    public static boolean isPalindrome(int num) {
        int temp = num;
        int reminder;
        int sum = 0;
        while (num > 0) {//121
            reminder = num % 10;// r=1 // r= 2 //r=1
            sum = sum * 10 + reminder;//s=0+1 // s=10+2 // s= 120+1
            num = num / 10;//n=12 // n=1
        }
        return temp == sum;
    }
}
