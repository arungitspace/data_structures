package stacks.problems;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String t : tokens){
            if(t != "+" && t != "-" && t != "*" && t != "/"){
                stack.push(Integer.parseInt(t));
            }else{
                if(t == "+"){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a+b);
                }
                else if(t == "-"){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a-b);
                }
                else if(t == "*"){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a*b);
                }
                else if(t == "/"){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a/b);
                }
            }
        }
        System.out.println(stack);
        System.out.println();
        System.out.println();
        return stack.pop();
    }
}
