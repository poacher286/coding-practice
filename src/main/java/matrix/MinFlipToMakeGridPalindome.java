package matrix;

public class MinFlipToMakeGridPalindome {
    /**
     * You are given an m x n binary matrix grid.
     *
     * A row or column is considered palindromic if its values read the same forward and backward.
     *
     * You can flip any number of cells in grid from 0 to 1, or from 1 to 0.
     *
     * Return the minimum number of cells that need to be flipped to make either all rows palindromic or all columns palindromic.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
     *
     * Output: 2
     */
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Calculate flips required to make all rows palindromic
        int rowFlips = 0;
        for (int i = 0; i < m; i++) {
            int flipsForRow = 0;
            for (int j = 0; j < n / 2; j++) {
                if (grid[i][j] != grid[i][n - 1 - j]) {
                    flipsForRow++;
                }
            }
            rowFlips += flipsForRow;
        }

        // Calculate flips required to make all columns palindromic
        int colFlips = 0;
        for (int j = 0; j < n; j++) {
            int flipsForCol = 0;
            for (int i = 0; i < m / 2; i++) {
                if (grid[i][j] != grid[m - 1 - i][j]) {
                    flipsForCol++;
                }
            }
            colFlips += flipsForCol;
        }

        // Return the minimum of the two
        return Math.min(rowFlips, colFlips);
    }
}
