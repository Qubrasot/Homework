package HW9.exercise94;

import java.util.Stack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        // push test
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        //size test
        System.out.println(stack.size());

        // pop test
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.size());

        //peek test
        System.out.println(stack.peek());

        //clear test
        stack.clear();
        System.out.println(stack.size());
    }
}
