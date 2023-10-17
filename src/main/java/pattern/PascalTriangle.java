package pattern;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static List<Integer> getRow(int rowIndex) {
        List<BigInteger> pascalTriangle = new ArrayList<>();
        int rowEle = rowIndex + 1;
        for (int r = 0; r < rowEle; r++) {
            //nCr = n!/r!(n-r)!
            BigInteger nCr = factorialBigInt(BigInteger.valueOf(rowIndex))
                            .divide(factorialBigInt(BigInteger.valueOf(r)).multiply(factorialBigInt(BigInteger.valueOf(rowIndex - r))));
            pascalTriangle.add(nCr);
        }
        return pascalTriangle
                .stream()
                .mapToInt(BigInteger::intValue)
                .boxed()
                .collect(Collectors.toList());
    }


    public static long factorial(int x, Map<Integer, Long> factMap){
        if (x <= 1){
            return 1;
        }
        if (factMap.containsKey(x)) {
            return factMap.get(x);
        }
        factMap.putIfAbsent(x, x * factorial(x - 1, factMap));
        return factMap.get(x);
    }

    public static BigInteger factorialBigInt(BigInteger num) {
        if (num.compareTo(BigInteger.TWO) < 0) return BigInteger.ONE;
        return num.multiply(factorialBigInt(num.subtract(BigInteger.ONE)));
    }


    public static void main(String[] args) {
        int n = 6;
        int rowIndex = 21;
        System.out.println(generate(n));
        System.out.println(getRow(rowIndex));
    }

}
