package queue.basic;

public class SecondTest {

    public static void main(String[] args) {
        ArrayQueueSecond<Integer> arr = new ArrayQueueSecond<>(5);
        arr.enqueue(1);
        arr.enqueue(2);
        arr.enqueue(3);
        arr.enqueue(4);
        arr.enqueue(5);
        arr.displayAll();
        arr.dequeue();
        arr.dequeue();
        arr.dequeue();
        arr.dequeue();
        arr.displayAll();
        arr.enqueue(6);
        arr.displayAll();
    }
}
