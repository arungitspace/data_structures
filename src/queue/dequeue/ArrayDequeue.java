package queue.dequeue;

import java.util.Arrays;

public class ArrayDequeue<T> {

    private T[] elements;
    private int start;
    private int end;
    private int size;

    public ArrayDequeue(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity can't be zero or less");
        }
        this.elements = (T[]) new Object[capacity];
        this.start = 0;
        this.end = 0;
        this.size = 0;
    }

    public void addFirst(T data){
        validateData(data);

        if(isFull()){
            grow();
        }
        int len = elements.length;
        start = (start - 1 + len) % len; // moving backward
        elements[start] = data;
        size++;
    }

    private void validateData(T data) {
        if(data == null){
            throw new IllegalArgumentException("data can't be null");
        }
    }

    public void addLast(T data){
        validateData(data);

        if(isFull()){
            grow();
        }
        elements[end] = data;
        end = (end + 1) % elements.length;
        size++;
    }

    public void grow(){
        int newSize = elements.length * 2;
        T[] newArr = (T[]) new Object[newSize];
        for(int i = 0; i < size; i++){
            newArr[i] = elements[(start + i) % elements.length];
        }
        elements  = newArr;
        start = 0;
        end = size;
    }
    public T removeLast(){
        if(isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        int len = elements.length;
        end = (end - 1 + len) % len;
        T data = elements[end];
        elements[end] = null;
        size--;
        return data;
    }

    public T removeFirst(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        T data = elements[start];
        elements[start] = null;
        start = (start + 1) % elements.length;
        size--;
        return data;
    }

    public T peekFirst(){
        if(isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        return elements[start];
    }

    public T peekLast(){
        if(isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        return elements[(end - 1 + elements.length) % elements.length];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == elements.length;
    }

    public void display(){
        System.out.println("start :"+start+" end : "+end+" size : "+size);
        System.out.println(Arrays.toString(elements));
    }

}
