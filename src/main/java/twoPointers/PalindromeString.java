package twoPointers;

public class PalindromeString {
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeRec(String s, int left, int right){
        if (left >= right){
            return true;
        }

        if (s.charAt(left) == s.charAt(right)){
            return isPalindromeRec(s, left + 1, right - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "nitin";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindromeRec(s, 0, s.length() - 1));
    }
}
