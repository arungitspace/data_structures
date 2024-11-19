package stacks.impls;

public class SecondStack<T> {

    private T[] stack;
    private int capacity;
    private int index;

    @SuppressWarnings("unchecked")
    public SecondStack(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity should be zero or less");
        }

        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
        this.index = -1;
    }

    public SecondStack(){
        this.capacity = 5;
        this.stack = (T[]) new Object[capacity];
        this.index = -1;
    }


    public void push(T data){
        if(data == null){
            throw new IllegalArgumentException("null value cannot be allowed in stack");
        }

        if(isFull()){
            grow();
        }
        stack[++index] = data;
    }

    public T pop(){
        if(isEmpty()){
            throw new IllegalStateException("stack is empty");
        }
        T data = stack[index];
        stack[index--] = null;
        return data;
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("stack is empty");
        }
        return stack[index];
    }

    @SuppressWarnings("unchecked")
    public void grow(){
        int newCap = capacity * 2;
        T[] newStack = (T[]) new Object[newCap];
        System.arraycopy(stack,0,newStack,0,capacity);
        this.stack = newStack;
        this.capacity = newCap;
    }

    public boolean isEmpty(){
        return index == -1;
    }

    public boolean isFull(){
        return index == capacity - 1;
    }

    public int size(){
        return index + 1;
    }



}
