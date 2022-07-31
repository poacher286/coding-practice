package strings;

public class SortSentence {
    /**
     * Input: s = "is2 sentence4 This1 a3"
     * Output: "This is a sentence"
     * Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
     * @param s
     * @return
     */
    public static String sortSentence(String s) {
        String[] split = s.split("\\s+");
        String[] res = new String[split.length];
        for (String str: split){
            int index = str.charAt(str.length()-1) - 48;
            res[index - 1] = str.substring(0, str.length()-1);
        }
        return String.join(" ", res);
    }

}
