package arryas;

import java.util.Arrays;

/**
 * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
 *
 * A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
 *
 * Note that points on the edge of a vertical area are not considered included in the area.
 *
 * Input: points = [[8,7],[9,9],[7,4],[9,7]]
 * Output: 1
 * Explanation: Both the red and the blue area are optimal.
 *
 * Approach
 * -> y-axis data are not relevant
 * -> sort the x-axis data
 * -> count max difference
 */
public class WidestVerticalArea {
    public static int maxWidthOfVerticalArea(int[][] points) {
        int[] xAxis = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xAxis[i] = points[i][0];
        }

        Arrays.sort(xAxis);
        int countMaxDiff = 0;
        for (int slow = 0; slow < xAxis.length - 1; slow++) {
            int fast = slow + 1;
            countMaxDiff = Math.max(countMaxDiff, xAxis[fast] - xAxis[slow]);
        }

        return countMaxDiff;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{8,7},{9,9},{7,4},{9,7}};
        System.out.println(maxWidthOfVerticalArea(points));
    }
}
