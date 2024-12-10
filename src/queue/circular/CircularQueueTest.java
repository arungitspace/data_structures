package queue.circular;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue<Integer> cq = new CircularQueue<>(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        cq.display();
        cq.dequeue();
        cq.dequeue();
        cq.display();
        cq.enqueue(6);
        cq.enqueue(7);
        cq.display();

        cq.enqueue(8);
        cq.display();

        String o = "leetcode";

        int max = Integer.MAX_VALUE;
        for(char i = 'a'; i <= 'z'; i++){
            int index = o.indexOf(i);
            if(index != -1 && index == o.lastIndexOf(i)){
                max = Math.min(max,index);
            }
        }

        System.out.println(max);
    }
}
