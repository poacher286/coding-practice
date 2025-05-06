package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        System.out.println("Natural order : ");
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(2);
        pq.offer(3);
        pq.offer(1);
        pq.offer(5);
        System.out.println(pq);
        System.out.println("peek : " + pq.peek());
        System.out.println("poll : " + pq.poll());
        System.out.println("peek : " + pq.peek());
        System.out.println("poll : " + pq.poll());
        System.out.println(pq);
    }
}
