package strings;

import java.util.ArrayList;
import java.util.List;

public class CellInRange {
    /**
     * Input: s = "K1:L2"
     * Output: ["K1","K2","L1","L2"]
     * Explanation:
     * The above diagram shows the cells which should be present in the list.
     * The red arrows denote the order in which the cells should be presented.
     * @param s
     * @return
     */
    public static List<String> cellsInRange(String s) { //K1:L2
        String ini = s.split(":")[0];//K1
        String end = s.split(":")[1];//L2
        List<String> cells = new ArrayList<>();
//        String str = "";
        char c = ini.charAt(0);
        while (c <= end.charAt(0)){

            for(int i = ini.charAt(1); i <= end.charAt(1); i++){
                cells.add(c + String.valueOf((char)i));
            }
            c++;
        }
        return cells;
    }

}
