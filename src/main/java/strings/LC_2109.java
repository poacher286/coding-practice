package strings;

public class LC_2109 {
    /**
     * You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original string where spaces will be added. Each space should be inserted before the character at the given index.
     *
     * For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C', which are at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
     * Return the modified string after the spaces have been added.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
     * Output: "Leetcode Helps Me Learn"
     * Explanation:
     * The indices 8, 13, and 15 correspond to the underlined characters in "LeetcodeHelpsMeLearn".
     * We then place spaces before those characters.
     * @param s
     * @param spaces
     * @return
     */
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int spacei = 0;
        for(int i = 0; i < s.length(); i++){
            if (spacei < spaces.length && i == spaces[spacei]){
                sb.append(" ");
                spacei++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        System.out.println(addSpaces(s, spaces));
    }
}
