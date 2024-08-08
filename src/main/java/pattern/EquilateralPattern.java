package pattern;

public class EquilateralPattern {
    public static void  equilateralTriangle(int n){
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print stars with spaces between them
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            // Move to the next line after printing each row
            System.out.println();
        }
    }

    public static void equilateralMatrix(int n){
        // Create a matrix to hold the triangle pattern
        char[][] triangle = new char[n][2 * n - 1];

        // Initialize the matrix with spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                triangle[i][j] = ' ';
            }
        }

        // Fill the matrix to create the filled equilateral triangle pattern
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j <= n + i - 1; j++) {
                triangle[i][j] = '*';
            }
        }

        // Print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                System.out.print(triangle[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        equilateralTriangle(5);
        equilateralMatrix(5);
    }
}
