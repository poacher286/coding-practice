package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLineWithFibonacci {
    public static void main(String[] args) throws IOException {
        String filePath = "./src/main/resources/input.txt";
        System.out.println(readFileWithFibonacciOrder(filePath));
    }

    public static String readFileWithFibonacciOrder(String filePath) throws IOException {
        char[] chars = Files.readString(Paths.get(filePath)).toCharArray();
        StringBuilder fibStr = new StringBuilder();
        for (int i = chars.length - 1; i > 0; i--) {
            if (isFibonacciNumber(chars.length - i))
                fibStr.append(chars[i]);
        }

        return fibStr.toString();
    }

    public static boolean isFibonacciNumber(int num) {
        if (num <= 2) return true;
        return isPerfectSquare(5 * num * num + 4) || isPerfectSquare(5 * num * num - 4);
    }

    public static boolean isPerfectSquare(int num) {
        int sq = (int) Math.sqrt(num);
        return (sq * sq == num);
    }


    /**
     *
     * int intfirst = 1
     * int intsecond = 1
     * int intthird = 2
     *
     * loop// i=0; i=chars.length; i++ // 100
     *          if(i == intthird){
     *              // if(chars[i] != ' ') sout(char[i])
     *              intfirst = intsecond
     *              intsecond = intthird
     *              intthird = intfirst + intsecond
     *        }
     */

}
