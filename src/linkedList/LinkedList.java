package linkedList;

public class LinkedList<T> {

    private int size;
    private Node<T> head;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            this.head = node;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        size++;
    }

    public void addAt(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("invalid index");
        }

        Node<T> node = new Node<>(data);
        if (index == 0) {

            node.setNext(head);
            head = node;

        } else {


            Node<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            Node<T> nextNode = current.getNext();
            node.setNext(nextNode);
            current.setNext(node);

        }
        size++;
    }

    public T removeLast() {
        T removedData;

        //if no elements in the collection
        if (size == 0) {
            throw new IllegalStateException("List is Empty");
        }
        // if only one node available
        if (size == 1) {
            removedData = head.getData();
            head = null;
        } else {
            Node<T> current = head;
            // finding one before the last node
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            // getting the value
            removedData = current.getNext().getData();
            current.setNext(null);
        }
        size--;
        return removedData;
    }

    public boolean removeByData(T data) {

        // no data
        if (head == null) {
            return false;
        }

        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                if (current.getNext().getData().equals(data)) {
                    current.setNext(current.getNext().getNext());
                    size--;
                    return true;
                } else {
                    current = current.getNext();
                }

            }
        }
        return false;
    }

    public int removeAll(T data) {
        int count = 0;

        if (data == null || head == null) {
            return 0;
        }

        while (head != null && head.getData().equals(data)) {
            head = head.getNext();
            size--;
            count++;
        }

        if (head == null) {
            return count;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                size--;
                count++;
            } else {
                current = current.getNext();
            }
        }

        return count;
    }

    public T remove(int index) {
        T removedData;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Given Index Invalid");
        }

        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
        } else {
            Node<T> current = head;
            // stopping before the intended index
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            removedData = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removedData;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Given Index Invalid");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    public boolean contains(T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void display() {

        Node<T> current = head;
        while(current != null){
            System.out.print(current.getData()+" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
