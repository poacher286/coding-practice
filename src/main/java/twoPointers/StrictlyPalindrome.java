package twoPointers;


import java.util.stream.IntStream;

/**
 * An integer n is strictly palindromic if, for every base b between 2 and n - 2 (inclusive), the string representation of the integer n in base b is palindromic.
 *
 * Given an integer n, return true if n is strictly palindromic and false otherwise.
 *
 * A string is palindromic if it reads the same forward and backward.
 *
 * Example 1 :
 * Input: n = 9
 * Output: false
 * Explanation: In base 2: 9 = 1001 (base 2), which is palindromic.
 * In base 3: 9 = 100 (base 3), which is not palindromic.
 * Therefore, 9 is not strictly palindromic so we return false.
 * Note that in bases 4, 5, 6, and 7, n = 9 is also not palindromic.
 */
public class StrictlyPalindrome {
    public static boolean isStrictlyPalindromic(int n) {
        boolean ans = false;
        for(int i=2; i<n-2; i++){
            int num = n;
            int reverse=0;
            int rem;
            while(num!=0){
                rem = num%i;
                reverse = (reverse*10)+(rem);
                num=num/i;
            }
            if(reverse==n){
                ans = true;
            }
            else{
                ans=false;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int strictPalin = IntStream.range(4, 100000)
                .filter(x -> isStrictlyPalindromic(x))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No int found"));

        System.out.println(strictPalin);
    }
}
