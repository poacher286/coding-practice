package strings;

/**
 * There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'. You are given a string colors of length n where colors[i] is the color of the ith piece.
 *
 * Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.
 *
 * Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. She is not allowed to remove pieces that are colored 'B'.
 * Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. He is not allowed to remove pieces that are colored 'A'.
 * Alice and Bob cannot remove pieces from the edge of the line.
 * If a player cannot make a move on their turn, that player loses and the other player wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.
 *
 *
 *
 * Example 1:
 *
 * Input: colors = "AAABABB"
 * Output: true
 * Explanation:
 * AAABABB -> AABABB
 * Alice moves first.
 * She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.
 *
 * Now it's Bob's turn.
 * Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
 * Thus, Alice wins, so return true.
 */
public class WinnerGame {
    public static boolean winnerOfGame(String colors) {
        int aliceScore = 0;
        int bobScore = 0;

        // Iterate through the colors, excluding the edge pieces
        for (int i = 1; i < colors.length() - 1; i++) {
            char currentColor = colors.charAt(i);
            char prevColor = colors.charAt(i - 1);
            char nextColor = colors.charAt(i + 1);

            // Check if Alice can make a move here
            if (currentColor == 'A' && prevColor == 'A' && nextColor == 'A')
                aliceScore++; // Alice can remove 'A'

                // Check if Bob can make a move here
            else if (currentColor == 'B' && prevColor == 'B' && nextColor == 'B')
                bobScore++; // Bob can remove 'B'
        }

        // Determine the winner based on the scores
        return aliceScore > bobScore;
    }

    public static void main(String[] args) {
        String colors = "AAAAABBB";
        System.out.println(winnerOfGame(colors));
    }
}
