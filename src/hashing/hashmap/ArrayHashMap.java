package hashing.hashmap;

import java.util.Arrays;
import java.util.Objects;

public class ArrayHashMap<K,V> {

    private class Entry<K,V>{
        final K key;
        V value;
        final int hash;
        Entry<K,V> next;

        public Entry(K key,V value,int hash){
            this.key = key;
            this.hash = hash;
            this.value = value;
        }

        public String toString(){
            return key + " " + value + " "+ hash + " "+ next;
        }
    }


    private int capacity = 16;
    private Entry[] bucket;

    public ArrayHashMap(){
        this.bucket = new Entry[capacity];
    }


    // hash function with bit manipulation
    private int hash(K key){
        return key == null ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
    }

    private int index(int hash){
        return hash & (capacity - 1);
    }

    // create
    public void put(K key, V value){
        int hash = hash(key);
        int index = index(hash);

        // update
        // updating existing key value
        Entry<K,V> nodes = bucket[index];
        while(nodes != null){
            if(hash == nodes.hash && Objects.equals(key,nodes.key)){
                nodes.value = value;
                return;
            }
            nodes = nodes.next;
        }

        Entry<K,V> newNode = new Entry<>(key,value,hash);
        newNode.next = bucket[index]; // making existing nodes follow new node
        bucket[index] = newNode; // made new node as head which already have other node references
    }

    // read
    public V get(K key){
        int hash = hash(key);
        int index = index(hash);
        Entry<K,V> current = bucket[index];
        while (current != null){
            if(current.hash == hash && Objects.equals(key,current.key)){
                return current.value;
            }
            current = current.next;
        }
        return null; // if not found
    }

    // delete
    public boolean remove(K key){
        int hash = hash(key);
        int index = index(hash);

        Entry<K,V> current = bucket[index];
        Entry<K,V> prev = null;

        while(current != null){
            if(hash == current.hash && Objects.equals(current.key,key)){
                if(prev == null){ // head node in that index
                    bucket[index] = current.next; // made next node as head
                }else{
                    prev.next = current.next; // in between or last node, we made prev node point to next node of current
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public void display(){
        System.out.println(Arrays.toString(bucket));
    }

    public void print(){
        for(int i = 0; i < capacity; i++){
            System.out.print("Bucket "+i+":");
            Entry<K,V> current = bucket[i];
            while (current != null){
                System.out.print(current.key+ "-"+current.value+ "-"+current.hash +" -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}
