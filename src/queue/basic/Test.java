package queue.basic;

public class Test {
    public static void main(String[] args) {
        ArrayQueue<Integer> arr = new ArrayQueue<>();
        arr.enqueue(12);
        arr.enqueue(13);
        arr.enqueue(14);
        arr.enqueue(15);
        arr.enqueue(16);
        arr.enqueue(17);


        /*System.out.println(arr.getSize());
        System.out.println(arr.isEmpty());
        System.out.println(arr.isFull());*/
        arr.displayArray();

        arr.dequeue();
        arr.dequeue();
        arr.displayArray();
    }
}
