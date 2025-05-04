package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Weekly448 {
    //product of max 2
    public static int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
            n = n / 10;
        }
        return max1 * max2;
    }

    public static int maxProduct2(int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n > 0) {
            int digit = n % 10;
            pq.offer(digit);
            if (pq.size() > 2) {
                pq.poll();
            }
            n = n / 10;
        }
        return pq.poll() * pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(maxProduct2(19999));
    }
}
