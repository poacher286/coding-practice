package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumIsland {
    /**
     * Write a method, minimumIsland, that takes in a grid containing Ws and Ls.
     * W represents water and L represents land.
     * The method should return the size of the smallest island.
     * An island is a vertically or horizontally connected region of land.
     *
     * You may assume that the grid contains at least one island.
     */

    public static int minimumIsland(List<List<String>> grid) {
        Set<String> visitedPositions = new HashSet<>();
        int minSize = 0;
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                int currSize = isIsland(grid, row, col, visitedPositions);
                minSize = Math.min(minSize, currSize);
            }
        }
        return minSize;
    }

    private static int isIsland(List<List<String>> grid, int row, int col, Set<String> visitedPositions) {
        boolean rowInbound = row >= 0 && row < grid.size();
        boolean colInbound = col >= 0 && col < grid.get(0).size();
        if (!rowInbound || !colInbound) return 0;

        if (grid.get(row).get(col) == "W") return 0;

        String position = row + "," + col;
        if (visitedPositions.contains(position)) return 0;
        visitedPositions.add(position);

        int size = 1;

        size += isIsland(grid, row - 1, col, visitedPositions);
        size += isIsland(grid, row + 1, col, visitedPositions);
        size += isIsland(grid, row, col - 1, visitedPositions);
        size += isIsland(grid, row, col + 1, visitedPositions);

        return size;
    }
}
