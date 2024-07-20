package bitmanipulation;

public class NumberOfStepsToReduceToOne {
    /**
     * 1404. Number of Steps to Reduce a Number in Binary Representation to One
     * Medium
     * Given the binary representation of an integer as a string s,
     * return the number of steps to reduce it to 1 under the following rules:
     *
     * If the current number is even, you have to divide it by 2.
     *
     * If the current number is odd, you have to add 1 to it.
     *
     * It is guaranteed that you can always reach one for all test cases.
     * @param s
     * @return
     */
    public static int numSteps(String s) {
        long actNumber = Long.parseLong(s, 2);
        int steps = 0;
        while (actNumber != 1) {
            if ((actNumber & 1) == 0) {
                actNumber = actNumber / 2;
            } else {
                actNumber = actNumber + 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));
    }
}
