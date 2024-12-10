package heap.array;

import java.util.Hashtable;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        MaxHeap<Integer> mh = new MaxHeap<>(5);

        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.offer(712);
        p.offer(23);
        p.offer(34);
        p.offer(22);
        p.offer(35);
        p.add(712);
        p.add(23);
        p.add(34);
        p.add(22);
        p.add(35);
        System.out.println(p);
        Hashtable<Integer,Integer> tb = new Hashtable<>();
        tb.put(null,1);
        System.out.println(tb);
    }
}
