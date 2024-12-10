package hashing.hashmap;

import java.util.*;

public class Test {
    public static void main(String[] args) {
/*        ArrayHashMap<Integer,Integer> ahm = new ArrayHashMap<>();
        Integer h = 12;
        System.out.println(h.hashCode() + " "+ (h.hashCode() / 16));
        ahm.put(12,21);
        ahm.display();*/
        ArrayHashMap<String,Integer> str = new ArrayHashMap<>();
        str.put("Aa",123);
        str.put("BB",344);
        str.display();
        str.print();

        Map<String,String> map = new HashMap<>();
        map.put(null,null);
        System.out.println(map);
        map.put(null,"hi");
        System.out.println(map);
        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        System.out.println(set);
        Map<String,String> ht = new Hashtable<>();
        ht.put(null,"null");
        System.out.println(ht);

    }
}
