package problems;

import java.util.PriorityQueue;

public class KClosestNumber {

    public static void main(String[] args) {
        int[] num = {1,1,2,3,4,5};
        int k = 4;
        int x = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < num.length; i++){
           if(k > 0){
               pq.add(num[i]);
               k--;
           }else if(Math.abs(pq.peek() - x) > Math.abs(num[i] - x)){
               pq.poll();
               pq.add(num[i]);
           }
        }

        System.out.println(pq);
    }

}
