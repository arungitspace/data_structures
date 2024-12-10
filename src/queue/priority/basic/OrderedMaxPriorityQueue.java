package queue.priority.basic;

import java.util.Arrays;

public class OrderedMaxPriorityQueue<T> {


    private T[] elements;
    private int[] prior;
    private int size;


    public OrderedMaxPriorityQueue(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity can't be zero or less");
        }

        this.elements = (T[]) new Object[capacity];
        this.prior = new int[capacity];
        this.size = 0;
    }

    // adding an element check priority with present one
    public void add(T data, int priority){
        if(data == null){
            throw new IllegalArgumentException("element can't be null");
        }

        if(size == elements.length){
            throw new IllegalStateException("queue is full");
        }

        int i = size - 1;
        while(i >= 0 && prior[i] < priority){
            elements[i+1] = elements[i];
            prior[i+1] = prior[i];
            i--;
        }

        elements[i+1] = data;
        prior[i+1] = priority;
        size++;
    }

    public T remove(){
        if(size == 0){
            throw new IllegalStateException("queue is empty");
        }

        T data = elements[0];
        for(int i = 0; i < size - 1; i++){
            elements[i] = elements[i+1];
            prior[i] = prior[i+1];
        }
        elements[size-1] = null;
        prior[size-1] = 0;
        size--;
        return data;
    }

    public T peek(){
        if(size == 0){
            throw new IllegalStateException("queue is empty");
        }
        return elements[0];
    }

    public void display(){
            System.out.println("size : "+ size);
            System.out.println(Arrays.toString(elements));
            System.out.println(Arrays.toString(prior));
    }


}
