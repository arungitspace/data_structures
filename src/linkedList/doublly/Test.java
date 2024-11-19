package linkedList.doublly;

public class Test {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addAtFirst(12);
        list.addAtFirst(11);
        list.addAtLast(14);
        list.addAtLast(15);
        list.add(0,9);
        list.add(1,10);
        list.display();
        list.displayBackWards();
    }
}
