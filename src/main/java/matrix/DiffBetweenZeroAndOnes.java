package matrix;

public class DiffBetweenZeroAndOnes {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1){
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        int[][] diff = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int onesRowi = rowCount[row];
                int onesColj = colCount[col];
                int zerosRowi = m - onesRowi;
                int zerosColj = n - onesColj;
                diff[row][col] = onesRowi + onesColj - zerosRowi - zerosColj;
            }
        }

        return diff;
    }
}
