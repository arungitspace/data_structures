package trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {


    private class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }

        public String toString(){
            return left + " " + data + " " + right;
        }
    }


    private Node root;

    public void add(int data){
        root = addNode(root,data);
    }

    private Node addNode(Node node, int data){
        if(node == null){
            return new Node(data);
        }

        if(node.left == null){
            node.left = addNode(null,data);
        }else{
            node.right = addNode(node.right,data);
        }

        return node;
    }

    public Node search(int value){
        return getNode(root,value);
    }

    private Node getNode(Node root, int data){
        if(root == null){
            return null;
        }
        if(root.data == data){
            return root;
        }

        Node result = null;
        if(root.left != null){
            result = getNode(root.left,data);
        }
        if(result == null){
            result = getNode(root.right,data);
        }
        return result;
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
