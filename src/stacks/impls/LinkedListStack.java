package stacks.impls;

import linkedList.single.LinkedList;

public class LinkedListStack<T> {

    private class Node{
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

    }

    private int size;
    private Node tail;

    public LinkedListStack(){
        this.size = 0;
        this.tail = null;
    }


    public void push(T data){
        if(data == null){
            throw new IllegalArgumentException("null value is not allowed in stack");
        }
        Node node = new Node(data);
        node.next = tail;
        tail = node;
        size++;
    }


    public T pop(){
        if(tail == null){
            throw new IllegalStateException("stack is empty");
        }
        T data = tail.data;
        tail = tail.next;
        size--;
        return data;
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("stack is empty");
        }
        return tail.data;
    }



    public boolean isEmpty(){
        return tail == null;
    }

    public int size(){
        return size;
    }

    public void clear(){
        this.tail = null;
        this.size = 0;
    }

    public void display(){
        if(isEmpty()){
            throw new IllegalStateException("stack is empty");
        }
        Node current = tail;
        System.out.println("top");
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("bottom");

    }

}
