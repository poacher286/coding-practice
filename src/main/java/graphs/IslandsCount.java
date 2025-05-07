package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandsCount {
    /**
     * Write a method, islandCount, that takes in a grid containing Ws and Ls.
     * W represents water and L represents land.
     * The method should return the number of islands on the grid.
     * An island is a vertically or horizontally connected region of land.
     */
    public static int islandCount(List<List<String>> grid) {

        //set to store visited position
        Set<String> visitedPositions = new HashSet<>();

        int count = 0;
        //iterate through all positions and if
        //we encounter land then dfs and find all neighboring land
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (foundIsland(grid, row, col, visitedPositions)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean foundIsland(List<List<String>> grid, int row, int col, Set<String> visitedPositions) {
        //use dfs to iterate all neighbor
        //base case
        //if row and col are outbound then return false
        boolean rowInbound = row >= 0 && row < grid.size();
        boolean colInbound = col >= 0 && col < grid.get(0).size();
        if (!rowInbound || !colInbound) return false;

        //if position is water retrun false
        if (grid.get(row).get(col) == "W") return false;

        //if positon is already visited then return false
        String postion = row + "," + col;
        if(visitedPositions.contains(postion)) return false;

        //if not visited then add in vistedPostions
        visitedPositions.add(postion);

        //iterate through all 4 direction and update
        foundIsland(grid, row - 1, col, visitedPositions);
        foundIsland(grid, row + 1, col, visitedPositions);
        foundIsland(grid, row, col - 1, visitedPositions);
        foundIsland(grid, row, col + 1, visitedPositions);

        return true;
    }

    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );

        System.out.println(islandCount(grid));
    }
}
