package matrix;

public class LargestLocalValues {
    public int[][] largestLocal(int[][] grid) {
        int row = grid.length - 2;
        int col = grid.length - 2;

        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                res[i][j] = solve(grid, i, j);
            }
        }
        return res;
    }

    private int solve(int[][] grid, int i, int j) {
        int ro = i + 3;
        int co = j + 3;
        int max = 0;
        for (int k = i; k < ro; k++) {
            for (int l = j; l < co; l++) {
                max = Math.max(max, grid[k][l]);
            }
        }
        return max;
    }
}
