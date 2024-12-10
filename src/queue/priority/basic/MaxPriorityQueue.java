package queue.priority.basic;

import java.util.Arrays;

public class MaxPriorityQueue<T> {

    private T[] elements;
    private int[] priorities;
    private int size;

    public MaxPriorityQueue(int capacity){
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

    public T remove(){
        if(size == 0){
            throw new IllegalStateException("queue is empty");
        }

        int maxIndex = 0;
        for(int i = 1; i < size; i++){
            if(priorities[i] > priorities[maxIndex]){
                maxIndex = i;
            }
        }

        T data = elements[maxIndex];
        elements[maxIndex] = elements[size-1];
        priorities[maxIndex] = priorities[size-1];
        size--;

        return data;
    }

    public T peek(){
        if(size == 0){
            throw new IllegalStateException("Queue is Empty");
        }

        int max = 0;
        for(int i = 1; i < size; i++){
            if(priorities[i] > priorities[max]){
                max = i;
            }
        }
        return elements[max];
    }

    public void display(){
        System.out.println("size : "+ size);
        System.out.println(Arrays.toString(elements));
        System.out.println(Arrays.toString(priorities));
    }
}
