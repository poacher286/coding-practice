package numbers;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
 *
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
 *
 * Return the number of bulbs that are on after n rounds.
 */
public class BulbSwitcher {
    public static int bulbSwitch(int n) {
        // Q : Find the number of bulbs that are ON after n rounds
        // The bulbs whose numbers have an odd number of factors will be ON after n rounds,
        // and if a number has an odd number of factors, it must be a perfect square.

        // Therefore, we can simply find the square root of n and return it as an integer.
        // The reason why we take the floor value of the square root is that we need to return
        // the count of perfect squares up to n, which is an integer value.

        // Find the square root of n and cast it to an integer --> floor value
        // Return the count of perfect squares
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(bulbSwitch(n));
    }
}
