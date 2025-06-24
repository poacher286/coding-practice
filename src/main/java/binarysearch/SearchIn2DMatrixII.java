package binarysearch;

public class SearchIn2DMatrixII {
    /**
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (bSearch(arr, target)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0){
            int val = matrix[row][col];
            if (val == target) return true;
            else if (val < target) row++;
            else col--;
        }

        return false;
    }

    public boolean bSearch(int[] arr, int tar) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = (start + end) / 2;
            if (arr[mid] == tar){
                return true;
            } else if (arr[mid] < tar) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
