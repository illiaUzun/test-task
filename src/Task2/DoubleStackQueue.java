package Task2;

import java.util.*;

public class DoubleStackQueue<E> {
    //Queue from 2 Stacks

    private Stack<E> stack1;
    private Stack<E> stack2;

    public DoubleStackQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * Method transfer data from stack2 to stack1
     * (so stack1 has the same data but in revers order)
     */
    private void swapData() {
        if (!stack1.empty()) {
        } else if (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     */
    public boolean add(E e) {
        this.stack2.push(e);
        return true;
    }

    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an exception if this
     * queue is empty.
     *
     * @return the head of this queue
     * @throws EmptyStackException if this queue is empty
     */
    public Object remove() {
        swapData();
        return stack1.pop();
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public Object poll() {
        swapData();
        try {
            return stack1.pop();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public Object peek() {
        swapData();
        try {
            return stack1.peek();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the head of this queue
     * @throws EmptyStackException if this queue is empty
     */
    public Object element() {
        swapData();
        return stack1.peek();
    }

    /**
     * Returns the size of the queue
     *
     * @return the size of the queue
     */
    public int size() {
        return stack1.size() + stack2.size();
    }

    /**
     * Checks if queue is empty
     *
     * @return true if queue is empty
     * false if queue is not emty
     */
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * Delete all elements from queue
     */
    public void clear() {
        stack1.clear();
        stack2.clear();
    }

    public static void main(String[] args) {
    }

}
