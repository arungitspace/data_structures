package linkedList.circular;

public class CircularLinkedList<T> {

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node head;


    public void add(T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;
            /*for(int i = 0; i < size - 1; i++){
                current = current.next;
            }*/
            while (current.next != head) {
                current = current.next;
            }
            current.next = node;
        }
        node.next = head;
        size++;
    }

    public void add(int index,T data){
        
    }

    public boolean remove(T data) {
        if (head == null) {
            throw new IllegalStateException("list empty");
        }

        Node current = head;
        Node prev = null;
        do {
            if (current.data.equals(data)) {
                if (current == head) {
                    if (size == 1) {
                        head = null;
                    }else{
                        while(current.next != head){
                            current = current.next;
                        }
                        current.next = head;
                    }
                }else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        return false;
    }

    public void display() {
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("head");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
