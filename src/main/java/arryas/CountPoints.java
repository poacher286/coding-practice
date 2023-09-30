package arryas;

import java.util.Arrays;

/**
 * Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * Output: [3,2,2]
 */
public class CountPoints {
    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] distances = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            int[] query = queries[i];
            int x2 = query[0];
            int y2 = query[1];
            int r = query[2];
            for (int[] point : points) {
                int x1 = point[0];
                int y1 = point[1];
                if (euclideanDistance(x1,y1,x2,y2) <= r){
                    count++;
                }
            }
            distances[i] = count;
        }
        return distances;
    }

    public static double euclideanDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{3,3},{5,3},{2,2}}, queries = {{2,3,1},{4,3,1},{1,1,2}};
        System.out.println(Arrays.toString(countPoints(points, queries)));
    }
}
