package pattern;

public class DiamondPattern {

    public static void diamond (int n){
        // Print the top half of the diamond
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            // Move to the next line after printing each row
            System.out.println();
        }

        // Print the bottom half of the diamond
        for (int i = n - 1; i > 0; i--) {
            // Print leading spaces
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            // Move to the next line after printing each row
            System.out.println();
        }
    }

    public static void  diamondMatrix(int n){
        int size = 2 * n - 1; // The total height and width of the diamond

        // Create a matrix to hold the diamond pattern
        char[][] diamond = new char[size][size];

        // Initialize the matrix with spaces
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diamond[i][j] = ' ';
            }
        }

        // Fill the matrix to create the filled diamond pattern
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j <= n + i - 1; j++) {
                diamond[i][j] = '*'; // Fill top half
                diamond[size - i - 1][j] = '*'; // Fill bottom half
            }
        }

        // Print the matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(diamond[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        diamond(5);
        diamondMatrix(5);
    }
}
