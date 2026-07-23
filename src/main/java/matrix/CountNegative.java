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

    //Binary search
    public int countNegatives2(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            int left = 0;
            int right = row.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] < 0) right = mid - 1;
                else left = mid + 1;
            }
            count += row.length - left;
        }
        return count;
    }

    /**
     *  4   3   2  -1
     *  3   2   1  -1
     *  1   1  -1  -2
     * -1  -1  -2  -3
     *  ^
     * @param grid
     * @return
     */
    public int countNegatives3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row = m - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                count += n - col;
                row--;
            } else {
                col++;
            }
        }

        return count;
    }
}
