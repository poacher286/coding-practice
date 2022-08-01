package strings;

public class CountAsterisks {
    /**
     * Input: s = "l|*e*et|c**o|*de|"
     * Output: 2
     * Explanation: The considered characters are underlined: "l|*e*et|c**o|*de|".
     * The characters between the first and second '|' are excluded from the answer.
     * Also, the characters between the third and fourth '|' are excluded from the answer.
     * There are 2 asterisks considered. Therefore, we return 2.
     * @param s
     * @return
     */
    public static int countAsterisks(String s) {
        String[] split = s.split("\\|");//pass escape character for this split
        int count = 0;
        for(int i=0; i<split.length; i+=2){
            for(int j =0; j< split[i].length(); j++){
                if(split[i].charAt(j)=='*') count++;
            }
        }
        return count;
    }

}
