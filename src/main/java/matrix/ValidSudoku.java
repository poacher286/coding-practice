package matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        return checkVertically(board) && checkHorizontally(board) && check3x3Boad(board);
    }

    //check valid vertical line
    public static boolean checkVertically(char[][] board){
        for (int i = 0; i < board.length; i++) {
            Set<Character> setNum = new HashSet<>();
            if (board[i][0] != '.'){
                if (!setNum.add(board[i][0])) {
                    return false;
                }
            }
        }
        return true;
    }

    //check valid horizontal line
    public static boolean checkHorizontally(char[][] board){
        for (int i = 0; i < board.length; i++) {
            Set<Character> setNum = new HashSet<>();
            if (board[0][i] != '.'){
                if (!setNum.add(board[0][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    //check valid 3x3 box
    public static boolean check3x3Boad(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char currVal = board[i][j];
                if (currVal != '.') {
                    if (!set.add(currVal + ":" + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                        {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }
}
