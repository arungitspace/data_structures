package queue.basic;

import java.util.Arrays;

public class ArrayQueue<T> {

    private T[] array;
    private int start;
    private int end;
    private int capacity;

    private int size;


    public ArrayQueue(){
        this.capacity = 5;
        this.array = (T[]) new Object[capacity];
        this.start = -1;
        this.end = 0;
        this.size = 0;
    }

    public ArrayQueue(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("array capacity can't be zero or less");
        }
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.start = -1;
        this.end = 0;
        this.size = 0;
    }


    public void enqueue(T data){
        if(data == null){
            throw new IllegalArgumentException("data can't be null");
        }
        if(isFull()){
            grow();
        }
        if(start > end) {
            if(start == -1) {
                array[end++] = data;
                start++;
                size++;
            }
        }
    }

    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        T data = array[start];
        array[start] = null;
        start++;
        size--;
        return data;
    }

    private void grow(){
        int newCapacity = capacity * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array,0,newArray,0,capacity);
        this.capacity  = newCapacity;
        this.array = newArray;
        this.start = 0; // todo
        //this.end = this.size - 1; // todo
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int getSize(){
        return size;
    }

    public void displayArray(){
        System.out.println("start : "+start);
        System.out.println("end : "+end);
        System.out.println(Arrays.toString(array));
    }
}
