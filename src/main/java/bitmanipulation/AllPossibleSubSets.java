package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubSets {
    /**
     * for i = 0 to i < 2^n
     * for j = 0 to j < n
     * if jth bit is 1
     * add in string
     *
     * @param a
     * @param n
     * @return
     */
    public static List<String> possibleSubSet(char[] a, int n) {
        List<String> setList = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) s += a[j];
            }
            setList.add(s);
        }
        return setList;
    }

}
