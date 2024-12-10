package trees.avl;

public class AVLTree {


    private class Node{
        private int data;
        private int height;
        private Node right,left;

        public Node(int data){
            this.data = data;
            this.height = 1;
            this.right = this.left = null;
        }
    }


    private Node root;

    private int height(Node node){
        return node == null ? 0 : node.height;
    }

    private void updateHeight(Node node){
        if(node != null){
            node.height = 1 + Math.max(height(node.left),height(node.right));
        }
    }

    private int balanceFactor(Node node){
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rotateRight(Node y){
        Node x = y.left;
        Node T2 = x.right;

        //rotate
        x.right = y;
        y.left = T2;

        //update height
        y.height = Math.max(height(y.left),height(y.right)) + 1;
        x.height = Math.max(height(x.left),height(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left),height(x.right)) + 1;
        y.height = Math.max(height(y.left),height(y.right)) + 1;

        return y;
    }


    public void add(int data){
        root = addResc(root,data);
    }

    private Node addResc(Node root, int data) {
        if(root == null){
            return new Node(data);
        }

        if(data < root.data){
            root.left = addResc(root.left,data);
        }else if(data > root.data){
            root.right = addResc(root.right,data);
        }else {
            return root;
        }
        updateHeight(root);

        int bal = balanceFactor(root);

        //1st LL
        // greater value than 1 and current nodes left data
        if(bal > 1 && data < root.left.data){
            // rotate right
            return rotateRight(root);
        }

        // 3rd LR
        if(bal > 1 && data > root.left.data){
            // rotate left
            root.left = rotateLeft(root.left);
            // rotate right
            return rotateRight(root);
        }

        // 2nd RR
        if(bal < -1 && data > root.right.data){
            // rotate left
            return rotateLeft(root);
        }

        // 4rd RL
        if(bal < -1 && data < root.right.data){
            // rotate right
            root.right = rotateRight(root.right);
            // rotate left
            return rotateLeft(root);
        }

        return root;
    }

    public void delete(int data){
        root = removeDesc(root,data);
    }

    private Node removeDesc(Node root, int data) {
        return null;
    }
}
