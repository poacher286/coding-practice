package matrix;

public class Boomrang {
    public static boolean isBoomerang(int[][] points) {
        //(y2-y1)/(x2-x1) == (y3-y1)/(x3-x1) --> slope --> same line
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) !=
                (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }

    public static void main(String[] args) {
        int[][] points = {
                {1, 1},
                {2, 3},
                {3, 2}};
        System.out.println(isBoomerang(points));
    }
}
