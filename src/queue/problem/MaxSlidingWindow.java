package queue.problem;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow1(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }


    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length == 1){
            return nums;
        }
        int count = 0;
        int result[] = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i++){
            int j = i + 1;
            int max = nums[i];
            while(j < (i + k)){
                if(nums[j] > max){
                    max = nums[j];
                }
                j++;
            }
            result[count] = max;
            count++;
        }
        return result;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k){
        int len = nums.length;
        if(k == 0 || len <= 1){
            return nums;
        }

        int result[] = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < len; i++){

            //checking the range whether within k or not
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }

            // checking from last element to start
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offer(i); // adding in end of the queue
            if(i - k + 1 >= 0){
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }

}
