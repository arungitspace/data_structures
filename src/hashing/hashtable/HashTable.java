package hashing.hashtable;


import java.util.Arrays;
import java.util.LinkedList;

public class HashTable<K,V> {

    private class Node{
        V value;
        K key;

        public Node(K key, V value){
            this.value = value;
            this.key = key;
        }
    }


    private LinkedList<Node>[] elements;
    private int size;
    private int capacity;

    public HashTable(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("invalid capacity to create hashtable");
        }
        this.size = 0;
        this.capacity = capacity;
        this.elements = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++){
            elements[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key){
        return Math.abs((key.hashCode()) % capacity);
    }

    public void put(K key, V value){
        int index = getBucketIndex(key);
        LinkedList<Node> llNode = elements[index];

        for(Node node : llNode){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        llNode.add(new Node(key,value));
        size++;
    }

    public V get(K key){
        int elementIndex = getBucketIndex(key);
        LinkedList<Node> nodes = elements[elementIndex];

        for(Node node : nodes){
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }

    public boolean delete(K key){
        int index = getBucketIndex(key);
        LinkedList<Node> nodes = elements[index];
        boolean result = nodes.removeIf(node -> node.key.equals(key));
        size--;
        return result;
    }

    public void display(){
        System.out.println("size :"+size);
        System.out.println(Arrays.toString(elements));
    }

}
