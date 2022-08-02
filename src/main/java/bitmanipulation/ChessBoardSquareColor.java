package bitmanipulation;

public class ChessBoardSquareColor {
    /**
     * Return true if the square is white, and false if the square is black.
     *
     * The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.
     *
     * brute - force approach
     * if x --> odd and y--> even
     * a2 (97, 50) [ASCI]--> white (true)
     *
     * or if x --> even and y --> odd
     * b1 (98, 49)--> white (true)
     *
     * optimize --> we can add 2 numbers and check for odd number
     * @param coordinates
     * @return
     */
    public static boolean squareIsWhite(String coordinates) {
        char hor = coordinates.charAt(0);
        char ver = coordinates.charAt(1);
//        return ((hor & 1) != 0 && (ver & 1) == 0) || ((hor & 1) == 0 && (ver & 1) != 0);
        return ((hor + ver) & 1) !=0;
    }

}
