package twoPointers;

public class ReverseString {
    /**
     * using two pointer
     * @param s
     */
    public void reverseString(char[] s) {
        int left_pointer = 0;
        int right_pointer= s.length -1;

        while(left_pointer < right_pointer){
            char temp = s[left_pointer];
            s[left_pointer++] = s[right_pointer];
            s[right_pointer--] = temp;
        }
    }
}
