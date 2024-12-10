package queue.priority.basic;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        //MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(5);
        OrderedMaxPriorityQueue<Integer> pq = new OrderedMaxPriorityQueue<>(5);
        pq.add(12,0);
        pq.add(23,8);
        pq.add(34,23);
        pq.add(89,3);
        pq.add(78,6);
        pq.display();
        pq.remove();
        pq.remove();
        pq.display();
        pq.add(91,7);
        pq.add(87,3);
        pq.display();
        System.out.println(pq.peek());
    }
}
