package heap.array;

import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {

    private T[] heap;
    private int size; // as pointer

    public MaxHeap(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity can't be zero or less");
        }
        this.heap = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }
    public void add(T data){
        if(data == null){
            throw new IllegalArgumentException("data can't be null");
        }
        if(isFull()){
            grow();
        }
        heap[size] = data;
        size++;
        heapifyUpMax(size - 1);
    }

    //logn
    private void heapifyUpMax(int index) {
        // max so incoming element's parent should greater or equal to it
        while(index > 0 && heap[parent(index)].compareTo(heap[index]) < 0){
            swap(index,parent(index));
            index = parent(index);
        }
    }

    private void heapifyUpMin(int index) {
        // min so incoming element's parent should less or equal to it
        while(index > 0 && heap[index].compareTo(heap[parent(index)]) < 0){
            swap(index,parent(index));
            index = parent(index);
        }
    }
    
    public T remove(){
        if(isEmpty()){
            throw new IllegalStateException("heap is empty");
        }
        T data = heap[0];
        heap[0] = heap[size - 1]; // taking last element to first
        size--;
        heapifyDown(0);
        return data;
    }

    private void heapifyDown(int index) {
        int max = index;
        int rightChild = rightChild(index);
        int leftChild = leftChild(index);

        if(leftChild < size && heap[leftChild].compareTo(heap[max]) > 0){
            max = leftChild;
        }

        if(rightChild < size && heap[rightChild].compareTo(heap[max]) > 0){
            max = rightChild;
        }

        if(max != index){
            swap(max,index);
            heapifyDown(max);
        }


    }

    private void swap(int index, int parent) {
        T temp = heap[index];
        heap[index] = heap[parent];
        heap[parent] = temp;
    }

    private void grow() {
    }

    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == heap.length;
    }

    public void display(){
        System.out.println("size : "+size);
        System.out.println(Arrays.toString(heap));
    }

}
