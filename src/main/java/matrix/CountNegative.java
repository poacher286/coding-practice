package matrix;

public class CountNegative {
    /**
     * ven a m x n matrix grid which is sorted in {@non-increasing} order
     * both row-wise and column-wise,
     * return the number of negative numbers in grid.
     *
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0){
                    count++;
                }
            }
        }
        return count;
    }
}
