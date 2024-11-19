package stacks.problems;

import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures1(int[] temp) {
        int[] result = new int[temp.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temp.length; i++){
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]){
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
    public static int[] dailyTemperatures2(int[] t) {
        int n = t.length;
        int[] res = new int[n];    // Result array to store the number of days to wait
        int[] mono = new int[n];   // Monotonic stack to store indices
        int top = -1;              // Top of the stack, initially empty

        for (int i = 0; i < t.length; i++) {
            // Check if the current temperature is greater than the temperature at the index stored in the stack
            while (top >= 0 && t[i] > t[mono[top]]) {
                // Calculate the difference in indices for the warmer day
                res[mono[top]] = i - mono[top];
                // Pop the top element from the stack
                top--;
            }

            // Push the current index onto the stack
            mono[++top] = i;
        }

        return res;
    }

}
