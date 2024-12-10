package trees.binarysearchtree;

import trees.binarytree.MyBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }


    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(int data) {
        root = addRec(root, data);
    }

    private Node addRec(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = addRec(node.left, data);
        } else if (data > node.data) {
            node.right = addRec(node.right, data);
        }
        return node;
    }

    public Node get(int data){
        return search(root,data);
    }

    private Node search(Node node, int data){
        if(node == null || node.data == data){
            return node;
        }

        // if given data is less then root node value - only search in left subtree [only half]
        if(data < node.data){
             return search(node.left,data);
        }
        // if not then search only in right subtree which also half the tree
        return search(node.right,data);
    }

    public Node remove(int data){
        return delete(root,data);
    }

    private Node delete(Node node, int data){
        if(node == null){
            return null;
        }
        if(data < node.data){
            node.left = delete(node.left,data);
        }else if(data > node.data){
            node.right = delete(node.right,data);
        }else {
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }

            node.data = min(node.right);
            node.right = delete(node.right,node.data);
        }
        return node;
    }

    private int min(Node node) {
        int min = node.data;
        while(node.left != null){
            node = node.left;
            min = node.data;
        }
        return min;
    }

    public void display(){
        //System.out.println(root);
        //transversal(root);
        //levelTransversal(root);
        printTreeRec(root,0);
    }


    public void levelTransversal(Node node){
        if(node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node n = queue.poll();
            System.out.print(n.data+" ");
            if(n.left != null) queue.add(n.left);
            if(n.right != null) queue.add(n.right);
        }
    }

    private void printTreeRec(Node root, int depth) {
        if (root == null) {
            return;
        }

        // Print the right subtree first (higher values)
        printTreeRec(root.right, depth + 1);

        // Print the current node with indentation based on depth
        System.out.println("  ".repeat(depth) + root.data);

        // Print the left subtree (lower values)
        printTreeRec(root.left, depth + 1);
    }

    public void transversal(Node node){
        if(node != null){
            transversal(node.left);
            System.out.print(node.data+" ");
            transversal(node.right);
        }
    }

}
