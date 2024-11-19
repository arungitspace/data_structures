package stacks.problems;

import java.util.Stack;

public class BaseBall {

    // https://leetcode.com/problems/baseball-game/

    public int calPoints1(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            switch (s) {
                case "D": {
                    Integer num = stack.peek();
                    num = num * 2;
                    stack.push(num);
                    break;
                }
                case "C": {
                    stack.pop();
                    break;
                }
                case "+": {
                    Integer last = stack.peek();
                    Integer secLast = stack.get(stack.size() - 2);
                    stack.push(last + secLast);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(s));
                    break;
                }
            }
        }

        int sum = 0;
        for(Integer s : stack){
            sum = sum + s;
        }

        return sum;
    }

    public int calPoints2(String[] operations) {
        int index = 0;
        int[] num = new int[operations.length];

        for(String op : operations){
            if(op.equals("+")){
                num[index] = num[index - 1] + num[index - 2];
                index++;
            }else if(op.equals("D")){
                num[index] = 2 * num[index - 1];
                index++;
            }
            else if(op.equals("C")){
                index--;
            }
            else {
                num[index] = Integer.parseInt(op);
                index++;
            }
        }

        int sum = 0;
        for(int i = 0; i < index; i++){
            sum+= num[i];
        }
        return sum;
    }
}
