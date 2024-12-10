package queue.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test {

    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();

        ArrayDequeue<Integer> arr = new ArrayDequeue<>(5);
        arr.addLast(12);
        System.out.println(arr.peekLast());
        System.out.println(arr.peekFirst());
        arr.display();
    }
}
