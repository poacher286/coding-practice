package matrix;

public class MatrixSum {

    public static int sumMatrixElements(int[][] matrix){
        int sum =0;
        for (int[] ints : matrix){
            for (int anInt : ints){
                sum += anInt;
            }
        }
        return sum;
    }
}
