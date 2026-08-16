package slidingWindow;

public class MaxPointsObtainFromCard {
    /**
     * There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
     *
     * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
     *
     * Your score is the sum of the points of the cards you have taken.
     *
     * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
     */
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int left = 0;
        int right = n - k;

        int sum = 0;

        // Initially take k cards from the right
        for (int i = right; i < n; i++) {
            sum += cardPoints[i];
        }

        int max = sum;

        // Replace right cards with left cards
        while (left < k) {
            sum += cardPoints[left++] - cardPoints[right++];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }
}
