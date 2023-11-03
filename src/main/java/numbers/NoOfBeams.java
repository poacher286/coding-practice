package numbers;

/**
 * Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.
 *
 * There is one laser beam between any two security devices if both conditions are met:
 *
 * The two devices are located on two different rows: r1 and r2, where r1 < r2.
 * For each row i where r1 < i < r2, there are no security devices in the ith row.
 * Laser beams are independent, i.e., one beam does not interfere nor join with another.
 *
 * Return the total number of laser beams in the bank.
 *
 * Input: bank = ["011001","000000","010100","001000"]
 * Output: 8
 */
public class NoOfBeams {
    public static int numberOfBeams(String[] bank) {
        int count = 0;
        int prev = 0;

        for (String floor : bank) {
            int ones = countOnes(floor);
            if (ones != 0) {
                count += ones * prev;
                prev = ones;
            }
        }

        return count;
    }

    private static int countOnes(String floor) {
        int ones = 0;
        for (char c : floor.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        return ones;
    }

    public static void main(String[] args) {
        String[] bank = new String[]{
                "011001",
                "000000",
                "010100",
                "001000"};

        System.out.println(numberOfBeams(bank));
    }
}
