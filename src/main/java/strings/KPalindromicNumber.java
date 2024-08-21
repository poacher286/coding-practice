package strings;

public class KPalindromicNumber {

    // Helper function to generate the full palindrome from the first half
    private static long createPalindrome(int firstHalf, int n) {
        String firstHalfStr = String.valueOf(firstHalf);
        String secondHalfStr = new StringBuilder(firstHalfStr.substring(0, n / 2)).reverse().toString();
        return Long.parseLong(firstHalfStr + secondHalfStr);
    }

    public static String findLargestKPalindromic(int n, int k) {
        // Calculate the upper and lower limits for the first half of the palindrome
        int upperLimit = (int) Math.pow(10, (n + 1) / 2) - 1;  // e.g., 999999 for 9 digits
        int lowerLimit = (int) Math.pow(10, (n + 1) / 2 - 1);  // e.g., 100000 for 9 digits

        // Iterate from the largest possible first half down to the smallest
        for (int firstHalf = upperLimit; firstHalf >= lowerLimit; firstHalf--) {
            // Generate the full palindrome
            long palindrome = createPalindrome(firstHalf, n);

            // Check if the palindrome is divisible by k
            if (palindrome % k == 0) {
                return String.valueOf(palindrome);
            }
        }

        return ""; // Return an empty string if no such number is found
    }

    public static void main(String[] args) {
        int n = 9;
        int k = 11;
        String result = findLargestKPalindromic(n, k);
        System.out.println(result);  // Example output: 999494999
    }
}
