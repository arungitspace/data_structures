package stacks.problems;

import java.util.Stack;

public class ValidParentheses {

    // https://leetcode.com/problems/valid-parentheses/

    public static boolean isValid1(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else if(c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else if(c == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }

        }
        return stack.isEmpty();
    }
    public static boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if(c == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
                if(c == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    // optimized stack
    public static boolean isValid3(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '('){
                stack.push(')');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }

        return stack.isEmpty();
    }

    //using array
    public static boolean isValid4(String input){
        int i = -1;
        char[] c = new char[input.length()];

        for(char ch : input.toCharArray()){
            if(ch == '{' || ch == '[' || ch == '('){
                c[i++] = ch;
            }else{
                if(i >= 0 &&
                        ((c[i] == '{' && ch == '}')
                        || (c[i] == '[' && ch == ']')
                        || (c[i] == '(' && ch == ')'))){
                    i--;
                }else{
                    return false;
                }
            }

        }

        return i == -1;
    }


}
