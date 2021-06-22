package memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * Grid traveller
 * number of Travel paths from top-left to bottom right
 */
public class GridTraveller {

    //Normal method
    //O(2^n)
    public static long travelPaths(long row, long col) {
        if (row == 1 && col == 1) return 1;
        if (row == 0 || col == 0) return 0;
        return travelPaths(row - 1, col) + travelPaths(row, col - 1);
    }

    //Memoization to optimize O(n)
    public static final Map<String, Long> memo = new HashMap<>();

    public static long travelPathsOptimized(long row, long col) {
        String key = row + "," + col;
        if (memo.containsKey(key))
            return memo.get(key);
        if (row == 1 && col == 1) return 1;
        if (row == 0 || col == 0) return 0;
        memo.put(key, travelPathsOptimized(row - 1, col) + travelPathsOptimized(row, col - 1));
        return memo.get(key);
    }

}
