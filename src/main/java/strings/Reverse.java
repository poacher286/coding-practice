package strings;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Reverse {
    //reverse a sentence/word
    public static String reverseString(String str){
        String rev = "";
        for (int i=str.length()-1; i>=0; i--){
            rev+=str.charAt(i);
        }
        return rev;
    }

    public static String reverseSentence(String sent){
        return Arrays.stream(sent.split("\\s+"))
                .map(Reverse::reverseString)
                .collect(Collectors.joining(" "));
    }

    public static boolean isPalindromeString(String str){
        return str.equals(reverseString(str));
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Chamber"));
        System.out.println(reverseSentence("Hey!! How are you?"));
        System.out.println(isPalindromeString("nitin"));
    }
}
