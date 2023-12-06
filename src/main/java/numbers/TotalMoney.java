package numbers;

/**
 * Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
 *
 * He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday,
 * he will put in $1 more than the day before.
 * On every subsequent Monday, he will put in $1 more than the previous Monday.
 * Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
 * M T W T F S S
 * 1 2 3 4 5 6 7
 * 2 3 4 5 6 7 8
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 10
 */
public class TotalMoney {
    public static int totalMoney(int n) {
        int monday = 1;
        int total = 0;

        while (n > 0){
            int moneyAtStartingOfWeek = monday;
            for (int day = 1; day <= Math.min(n, 7); day++){
                total += moneyAtStartingOfWeek;
                moneyAtStartingOfWeek++;
            }
            n = n - 7;
            monday++;
        }

        return total;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalMoney(n));
    }
}
