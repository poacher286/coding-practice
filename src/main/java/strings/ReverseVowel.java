package strings;

public class ReverseVowel {
    public static String reverseVowels(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        char[] chars = s.toCharArray();
        while (leftPointer < rightPointer){
            // Find the leftmost vowel
            while (leftPointer < s.length () && !isVowel(chars[leftPointer])) {
                leftPointer++;
            }
            // Find the rightmost vowel
            while (rightPointer >= 0 && !isVowel(chars[rightPointer])) {
                rightPointer--;
            }

            //swap if leftPointer < rightPointer
            if (leftPointer < rightPointer){
                char temp = chars[rightPointer];
                chars[rightPointer--] = chars[leftPointer];
                chars[leftPointer++] = temp;
            }
        }

        return new String(chars);
    }

    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                 c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
