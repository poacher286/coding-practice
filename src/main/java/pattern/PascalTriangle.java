package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> rowValue = new ArrayList<>();
        rowValue.add(1);
        ans.add(rowValue);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = ans.get(i - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < i; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            newRow.add(1);
            ans.add(newRow);

        }
        return ans;
    }


    public static void main(String[] args) {
        int n = 6;
        System.out.println(generate(n));
    }

}
