package stacks.impls;

public class MyStack<T> {

    private T[] stack;
    private int index;
    private int capacity;
    @SuppressWarnings("unchecked")
    public MyStack(){
        capacity = 5;
        stack = (T[]) new Object[capacity];
        index = -1;
    }
    @SuppressWarnings("unchecked")
    public MyStack(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity must be greater than zero");
        }
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
        index = -1;
    }

    public void push(T data){
        if(data == null){
            throw new IllegalArgumentException("null value not allowed");  // exception name change
        }
        if(isFull()){
            grow();
        }
        stack[++index] = data;
    }

    public void grow(){
        int newSize = capacity * 2; // exponential
        T[] newstack = (T[]) new Object[newSize];
        /*for(int i = 0; i < capacity; i++){ // enhanced
            newstack[i] = stack[i];
        }*/
        System.arraycopy(stack,0,newSize,0,capacity);
        capacity = newSize;
        stack = newstack;
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack[index];
    }

    public T pop(){
        if(isEmpty()){
            throw new IllegalStateException("stack is empty");
        }
        T data = stack[index];
        stack[index--] = null;
        return data;
    }


    public boolean isEmpty(){
        return index == -1; //bug
    }

    public boolean isFull(){
        return index == capacity - 1; // bug
    }

    public int size(){
        return index + 1; //bug
    }
}
