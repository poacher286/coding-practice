package graphs;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {
    /**
     * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
     *
     * Connect: A cell is connected to adjacent cells horizontally or vertically.
     * Region: To form a region connect every 'O' cell.
     * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
     * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
     */
    public void solve(char[][] board) {
        Set<String> visited = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1 && board[row][col] == 'O') {
                    dfsExplore(board, row, col, visited);
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'T') board[row][col] = 'O';
            }
        }

        System.out.println(Arrays.deepToString(board));
    }

    private void dfsExplore(char[][] board, int row, int col, Set<String> visited) {
        boolean rowInbound = row >= 0 && row < board.length;
        boolean colInbound = col >= 0 && col < board[0].length;
        if (!rowInbound || !colInbound) return;

        if (board[row][col] == 'X') return;

        String position = row + "," + col;
        if (visited.contains(position)) return;
        visited.add(position);

        board[row][col] = 'T';
        dfsExplore(board, row - 1 , col, visited);
        dfsExplore(board, row + 1, col, visited);
        dfsExplore(board, row, col - 1, visited);
        dfsExplore(board, row, col + 1, visited);

    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        sr.solve(board);
    }
}
