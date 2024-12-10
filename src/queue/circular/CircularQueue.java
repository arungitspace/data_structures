package queue.circular;

import java.util.Arrays;

public class CircularQueue<T> {

    private int start;
    private T[] array;
    private int end;
    private int size;

    public CircularQueue(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("array capacity can't be zero or less");
        }
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.start = 0;
        this.end = -1;
    }



    public void enqueue(T data){
        if(data == null){
            throw new IllegalArgumentException("invalid value");
        }
        if(isFull()){
            grow();
        }
        end = (end + 1) % array.length;
        array[end] = data;
        size++;
    }

    private void grow() {
        int newSize = array.length * 2;
        T[] newArr = (T[]) new Object[newSize];
        for(int i = 0; i < size; i++){
            newArr[i] = array[(i + start) % array.length];
        }
        array = newArr;
        end = size - 1;
        start = 0;
    }

    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        T data = array[start];
        array[start] = null;
        start = (start + 1) % array.length;
        size--;
        return data;

    }


    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }

    public int size(){
        return size;
    }

    public void display(){
        System.out.println("start : "+start+ " ,end : "+end+ " ,size : "+size);
        System.out.println(Arrays.toString(array));
    }

}
