package graphs;

import java.util.HashSet;
import java.util.Set;

public class CountSubIsland {
    /**
     *You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
     *
     * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
     *
     * Return the number of islands in grid2 that are considered sub-islands.
     */

    private static boolean[][] visited;
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        int R = grid1.length;
        int C = grid1[0].length;
        visited = new boolean[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid2[row][col] == 1 && !visited[row][col] && dfsExplore(grid1, grid2, row, col)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean dfsExplore(int[][] grid1, int[][] grid2, int row, int col) {
        boolean rowInbound = row >= 0 && row < grid1.length;
        boolean colInbound = col >= 0 && col < grid1[0].length;

        if (!rowInbound || !colInbound || grid2[row][col] == 0 || visited[row][col]) return true;

        visited[row][col] = true;

        boolean res = true;

        if (grid1[row][col] == 0) res = false;

        res &= dfsExplore(grid1, grid2, row - 1, col);
        res &= dfsExplore(grid1, grid2, row + 1, col);
        res &= dfsExplore(grid1, grid2, row, col - 1);
        res &= dfsExplore(grid1, grid2, row, col + 1);

        return res;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};

        System.out.println(countSubIslands(grid1, grid2));
    }

}
