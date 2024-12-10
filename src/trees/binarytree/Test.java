package trees.binarytree;

import trees.binarysearchtree.BinarySearchTree;

public class Test {

    public static void main(String[] args) {
        //MyBinaryTree b = new MyBinaryTree();
        BinarySearchTree b = new BinarySearchTree();
        b.add(12);
        b.add(45);
        b.add(34);
        b.add(48);
        b.add(11);
        b.add(23);
        b.display();
        System.out.println();
    }
}
