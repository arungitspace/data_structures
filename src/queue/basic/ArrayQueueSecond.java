package queue.basic;

import java.util.Arrays;

public class ArrayQueueSecond<T> {

    private int size;
    private int start;
    private int end;
    private T[] array;

    public ArrayQueueSecond(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity shouldn't be zero or less");
        }
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.start = 0;
        this.end = -1;
    }



    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        T data = array[start];
        array[start] = null;
        size--;
        start++;

        // little optimization
        if(isEmpty()){
            start = 0;
            end = -1;
        }

        return data;
    }

    public T peek(){
        if(isEmpty()){
            throw new NullPointerException();
        }
        return array[start];
    }

    public void enqueue(T data){
        if(data == null){
            throw new NullPointerException();
        }
        if(isFull()){
            grow();
        }
        end++;
        array[end] = data;
        size++;
    }
    private void grow() {
        int newSize = array.length * 2;
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array,start,newArray,0,size); // instead of size = end - start + 1
        this.array = newArray;
        this.start = 0;
        this.end = size - 1; // end = end - start
    }

    private void gptGrow(){
        int newSize = array.length * 2;
        T[] newArr = (T[]) new Object[newSize];
        for(int i = start; i <= end; i++){
            newArr[i - start] = array[i];
        }
        end =  end - start;
        start = 0;
        array = newArr;

    }


    public boolean isFull(){
        // end == capacity - 1 checking last index of array points. if capacity as separate variable then works
        //return size == array.length; // not work
        //return end == size - 1; not work
        return end == array.length - 1;
    }

    public boolean isEmpty(){
        // return size == 0;
        return start > end;
    }

    public int getSize(){
        return end - start + 1;
    }

    public void displayAll(){
        System.out.println("start : "+start);
        System.out.println("end : "+end);
        System.out.println("size : "+size);
        System.out.println(Arrays.toString(array));
    }


}
