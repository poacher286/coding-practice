package slidingWindow;

/**
 * A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
 *
 * You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
 *
 * Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
 * Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
 *
 *
 *
 * Example 1:
 *
 * Input: answerKey = "TTFF", k = 2
 * Output: 4
 */
public class MaxConfusionInExam {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int i = 0, j = 0, ans = 0;
        int N = answerKey.length();
        int tCount = 0;
        int fCount = 0;
        for (; j < N; ++j) {
            // CODE: use A[j] to update state which might make the window invalid
            if(answerKey.charAt(j) == 'T'){
                tCount++;
            }else{
                fCount++;
            }
            int currAllowed = Math.min(tCount, fCount);
            for (; currAllowed > k; ++i) {
                // CODE: update state using A[i]
                if(answerKey.charAt(i) == 'T'){
                    tCount--;
                }else{
                    fCount--;
                }
                currAllowed = Math.min(tCount, fCount);
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String answerKey = "TTFF";
        int k = 2;
        System.out.println(maxConsecutiveAnswers(answerKey, k));
    }
}
