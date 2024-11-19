package linkedList.doublly;


import java.util.NoSuchElementException;

class Node<T>{

    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }


}
public class DoublyLinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;


    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void addAtFirst(T data){
        Node<T> node = new Node<>(data);
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addAtLast(T data){
        Node<T> node = new Node<>(data);
        if(tail == null){
            head = tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void add(int index, T data){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("invalid index");
        }
        if(index == 0){
            addAtFirst(data);
        }
        else if(index == size){
            addAtLast(data);
        }else{
            Node<T> node = new Node<>(data);
            Node<T> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            node.prev = current.prev;
            node.next = current;
            current.prev.next = node;
            current.prev = node;
            size++;
        }
    }

    public T removeLast(){
        T removed;

        if(isEmpty()){
            throw new NoSuchElementException("list is empty");
        }else{
            removed = tail.data;
            tail = tail.prev;
            size--;

            if(isEmpty()){
                head = null;
            }else{
                tail.next = null;
            }
        }
        return removed;
    }

    public T removeFirst(){
        T removed;
        if(isEmpty()){
            throw new IllegalStateException("list is empty");
        }else {
            removed = head.data;
            head = head.next;
            size--;

            if (isEmpty()) {
                tail = null;
            }else{
                head.prev = null;
            }
        }
        return removed;
    }

    public T remove(int index){

        if(index < 0 || index > size){
            throw new IllegalStateException("list is empty");
        }

        if(index == 0){
            return removeFirst();
        }else if(index == size - 1){
            return removeLast();
        }else {
            Node<T> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            T data =  current.data;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return data;
        }
    }

    public T get(int index){

        if(index < 0 || index >= size){ //size as 4 and input is 4
            throw new IllegalStateException("invalid index");
        }

        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public boolean contains(T data){

        Node<T> current = head;
        while(current != null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void display(){
        Node<T> current = head;
        while(current != null){
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackWards(){
        Node<T> current = tail;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}
