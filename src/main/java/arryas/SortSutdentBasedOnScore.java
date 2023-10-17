package arryas;

import java.util.Arrays;

public class SortSutdentBasedOnScore {
    public static int[][] sortTheStudents(int[][] score, int k) {
        // sort the matrix rows based on k-th index of each row
        Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
        return score;
    }

    public static void main(String[] args) {
        int[][] score = {{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int k = 2;
        System.out.println(Arrays.deepToString(sortTheStudents(score, k)));
    }
}
