package binarysearch;

public class SearchIn2DMatrix {

    /**
     * You are given an m x n integer matrix matrix with the following two properties:
     *
     * Each row is sorted in non-decreasing order.
     * The first integer of each row is greater than the last integer of the previous row.
     * Given an integer target, return true if target is in matrix or false otherwise.
     *
     * You must write a solution in O(log(m * n)) time complexity.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / col;
            int c = mid % col;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
