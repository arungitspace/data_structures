package linkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(12);
        myList.add(13);
        myList.add(13);
        myList.add(13);
        myList.add(13);
        System.out.println(myList.size());
        myList.removeLast();
        System.out.println(myList.size());
    }
}
