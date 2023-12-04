package strings;

public class LargestGoodInteger {
    public String largestGoodInteger(String num) {
        char maxChar = ' ';
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 2) && num.charAt(i) == num.charAt(i - 1)){
                maxChar = (char) Math.max(maxChar, num.charAt(i));
            }
        }

        if (maxChar == ' '){
            return "";
        }

        return new String(new char[]{maxChar, maxChar, maxChar});
    }
}
