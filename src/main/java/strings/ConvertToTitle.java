package strings;

public class ConvertToTitle {
    /**
     * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
     *
     * For example:
     *
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     *
     *
     * Example 1:
     *
     * Input: columnNumber = 1
     * Output: "A"
     * Example 2:
     *
     * Input: columnNumber = 28
     * Output: "AB"
     * Example 3:
     *
     * Input: columnNumber = 701
     * Output: "ZY"
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            ans.append((char) (((columnNumber) % 26) + 'A'));
            columnNumber = columnNumber / 26;
        }
        return ans.reverse().toString();
    }

    /**
     * Example 1:
     *
     * Input: columnTitle = "A"
     * Output: 1
     * Example 2:
     *
     * Input: columnTitle = "AB"
     * Output: 28
     * Example 3:
     *
     * Input: columnTitle = "ZY"
     * Output: 701
     * @param columnTitle
     * @return
     */
    public static int titleToNumber(String columnTitle) {

        int sum = 0;
        char[] charArray = columnTitle.toCharArray();
        for (char c : charArray) {
            sum = sum * 26 + (c - 'A' + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        String columnTitle = "FXSHRXW";
        System.out.println(titleToNumber(columnTitle));
    }
}
