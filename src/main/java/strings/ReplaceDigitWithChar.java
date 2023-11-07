package strings;

public class ReplaceDigitWithChar {
    public String replaceDigits(String s) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i++) {
            if ((i & 1) != 0) {
                char c = shift(ch[i - 1], ch[i] - '0');
                ch[i] = c;
            }
        }
        return new String(ch);
    }

    public char shift(char ch, int num) {
        for (int i = 1; i <= num; i++) {
            ch++;
        }
        return ch;
    }
}
