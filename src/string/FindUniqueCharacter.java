package string;

import java.util.Arrays;
import java.util.HashMap;

public class FindUniqueCharacter {

    // https://leetcode.com/problems/first-unique-character-in-a-string

    public static int firstUniqueChar1(String o) {
        int result = Integer.MAX_VALUE;
        for(char i = 'a'; i <= 'z'; i++){
            int index = o.indexOf(i);
            if(index != -1 && index == o.lastIndexOf(i)){
                result = Math.min(result,index);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * above one solve the problem but TC will be 2n
     * because of indexOf and LastIndexOf methods
     * */

    // without inbuilt methods
    public static int firstUniqueChar2(String o) {
        char[] ch = o.toCharArray();
        int[] freq = new int['z' + 1];
        for(char c: ch){
            freq[c]++;
        }

        for(int i = 0; i < ch.length; i++){
            if(freq[ch[i]] == 1){
                return i;
            }
        }

        return -1;
    }

    // with map
    public static int firstUniqueChar3(String s){
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char a : s.toCharArray()) {
            mp.put(a, mp.getOrDefault(a, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) { // this one i missed instead of finding a DS
            if (mp.get(s.charAt(i)) == 1) { // for ordered insertion start from 1st element in string
                return i;
            }
        }

        return -1;
    }

    // below solution have uniqueness in terms of array size
    // same as firstUniqueChar2
    // but with 26 element by - from that char - 'a' or end - start
    public static int firstUniqueChar4(String s){
            int freq [] = new int[26];
            for(int i = 0; i < s.length(); i ++)
                freq [s.charAt(i) - 'a'] ++; // beauty
            for(int i = 0; i < s.length(); i ++)
                if(freq [s.charAt(i) - 'a'] == 1) // beauty
                    return i;
            return -1;
    }
}
