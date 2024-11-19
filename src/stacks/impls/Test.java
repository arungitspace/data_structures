package stacks.impls;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(12);
        stack.push(23);
        stack.push(90);
        stack.display();
        stack.pop();
        System.out.println(stack.peek());
        stack.push(909);
        System.out.println(stack.pop());
        System.out.println(stack.size());


        Stack<Integer> st = new Stack<>();
        st.push(12);
        st.push(13);
        st.push(14);
        System.out.println(st.get(st.size() - 2));
    }
}
