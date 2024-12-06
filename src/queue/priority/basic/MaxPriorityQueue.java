package queue.priority.basic;

import java.util.Arrays;

public class PriorityQueue<T> {

    private T[] elements;
    private int[] priorities;
    private int size;

    public PriorityQueue(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity can't be zero or less");
        }
        this.elements = (T[]) new Object[capacity];
        this.priorities = new int[capacity];
        this.size = 0;
    }


    public void add(T data, int priority){
        if(this.size == elements.length){
            throw new IllegalStateException("Queue is full");
        }
        elements[size] = data;
        priorities[size] = priority;
        size++;
    }

    public void display(){
        System.out.println("size : "+ size);
        System.out.println(Arrays.toString(elements));
        System.out.println(Arrays.toString(priorities));
    }
}
