package hashing.hashtable;

import java.util.Arrays;

public class ArrayHashTable<K,V> {
    private class Entry<K,V>{
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key.toString()+"="+value.toString();
        }
    }

    private int capacity;
    private Entry<K,V>[] bucket;
    //load factor ?
    private final double load_factor = 0.75;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayHashTable(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity can't be zero or less");
        }
        this.capacity = capacity;
        //this.bucket = new Entry<?,?>[capacity]; // new Entry<K,V> gives issue but not wildcards
        this.bucket = (Entry<K, V>[]) new Entry[capacity]; //
        this.size = 0;
    }

    private int getBucketIndex(K key){
        return Math.abs(key.hashCode() % capacity);
    }


    // need to which bucket
    // already available key then override
    // else create a node and add
    public void put(K key,V value){
        int index = getBucketIndex(key);
        while(bucket[index] != null){
            if(bucket[index].key.equals(key)){
                bucket[index].value = value;
                return;
            }
            index = (index + 1) % capacity;
        }
        bucket[index] = new Entry<>(key,value);
        size++;
    }

    public V get(K key){
        int index = getBucketIndex(key);
        int start = index;
        while (bucket[index] != null){
            if(bucket[index].key.equals(key)){
                return bucket[index].value;
            }
            index = (index + 1) % capacity;
            if(index == start) break; // if size is full so no null value to stop loop
        }
        return null;
    }

    public boolean remove(K key){
        int index = getBucketIndex(key);
        int start = index;
        while(bucket[index] != null){
            if(bucket[index].key.equals(key)){
                bucket[index] = null;
                size--;
                rehash(index);
                return true;
            }
            if(start == index) break;
            index = (index + 1) % capacity;
        }
        return false;
    }

    private void rehash(int deletedIndex) {
        int nextIndex = (deletedIndex + 1) % capacity;
        while(bucket[nextIndex] != null){
            Entry delete = bucket[nextIndex];
            bucket[nextIndex] = null;
            size--;
            put((K)delete.key,(V)delete.value);
            nextIndex = (nextIndex + 1) % capacity;
        }
    }

    public void display(){
        System.out.println(Arrays.toString(bucket));
    }

}
