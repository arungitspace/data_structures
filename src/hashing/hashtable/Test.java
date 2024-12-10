package hashing.hashtable;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashTable<Integer,Integer> hm = new HashTable<>(5);

        ArrayHashTable<Integer,Integer> ahm = new ArrayHashTable<>(5);
        ahm.put(1,23);
        ahm.put(2,89);
        ahm.put(3,89);
        ahm.put(98,78);
        ahm.display();
        ahm.remove(3);
        ahm.display();
        System.out.println(ahm.get(98));


    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n,count.getOrDefault(n,0) + 1);
        }
        int sum = 0;
        Queue<Integer> q = new PriorityQueue<>((a,b) -> count.get(b) - count.get(a));
        
        for(Map.Entry<Integer,Integer> c : count.entrySet()){
            if(c.getValue() > 1){
                sum = c.getKey() * (c.getValue() - 1) / 2;
            }
        }
        return sum;
    }
}
