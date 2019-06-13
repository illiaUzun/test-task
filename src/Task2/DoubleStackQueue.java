package Task2;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class DoubleStackQueue {
    //Queue from 2 Stacks

    private Stack<Object> stack1;
    private Stack<Object> stack2;

    public DoubleStackQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    private void swapData() {
        if (!stack1.empty()) {
        } else {
            stack1.push(stack2.pop());
        }
    }

    public void add(Object o) {
        this.stack2.push(o);
    }


    public Object remove() throws NoSuchElementException {
        swapData();
        return stack1.pop();
    }

    public Object peek() {
        swapData();
        return stack1.peek();
    }

    public Object poll() {
        return null;
    }

    public Object element() throws NoSuchElementException {
        return null;
    }


//
//    public boolean offer(Object o) {
//        return false;
//    }
//
//    public int size() {
//        return 0;
//    }
//
//    public boolean isEmpty() {
//        return false;
//    }
//
//    public boolean contains(Object o) {
//        return false;
//    }
//
//    public Iterator iterator() {
//        return null;
//    }
//
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    public Object[] toArray(Object[] a) {
//        return new Object[0];
//    }


    public static void main(String[] args) {
        Queue<Integer> test = new ArrayDeque<>();
    }

}
