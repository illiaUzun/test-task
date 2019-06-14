package Task2;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class DoubleStackQueueTest {

    @Test
    void addToRemove() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(1);
        doubleStackQueue.add(2);
        doubleStackQueue.add(3);

        assertEquals(3, doubleStackQueue.remove());
        assertEquals(2, doubleStackQueue.remove());
        assertEquals(1, doubleStackQueue.remove());
    }

    @Test
    void addNull() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(null);

        assertEquals(null, doubleStackQueue.remove());
    }

    @Test
    void removeEmpty() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();

        assertThrows(EmptyStackException.class, () -> doubleStackQueue.remove());
    }

    @Test
    void peek() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(322);
        assertEquals(322, doubleStackQueue.peek());
    }

    @Test
    void peekEmpty() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        assertEquals(null, doubleStackQueue.peek());
    }

    @Test
    void element() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(322);
        assertEquals(322, doubleStackQueue.element());
    }

    @Test
    void elementEmpty() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        assertThrows(EmptyStackException.class, () -> doubleStackQueue.element());
    }

    @Test
    void poll() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(1);
        doubleStackQueue.add(2);
        doubleStackQueue.add(3);

        assertEquals(3, doubleStackQueue.poll());
        assertEquals(2, doubleStackQueue.poll());
        assertEquals(1, doubleStackQueue.poll());
    }

    @Test
    void pollEmpty() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();

        assertEquals(null, doubleStackQueue.poll());
    }

    @Test
    void size() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(1);
        doubleStackQueue.add(2);
        doubleStackQueue.add(3);

        assertEquals(3, doubleStackQueue.size());
    }

    @Test
    void isEmpty() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        assertEquals(true, doubleStackQueue.isEmpty());

        doubleStackQueue.add(1);
        assertEquals(false, doubleStackQueue.isEmpty());
    }

    @Test
    void isEmptyTest() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        assertEquals(true, doubleStackQueue.isEmpty());
    }

    @Test
    void isEmptyClear() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();

        doubleStackQueue.add(1);
        doubleStackQueue.add(2);
        doubleStackQueue.remove();
        doubleStackQueue.add(3);
        doubleStackQueue.remove();

        doubleStackQueue.clear();

        assertEquals(true, doubleStackQueue.isEmpty());
    }

    @Test
    void isEmptyTestWithAdd() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(1);
        doubleStackQueue.add(2);
        doubleStackQueue.remove();

        assertEquals(false, doubleStackQueue.isEmpty());
    }

    @Test
    void clear() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(1);
        doubleStackQueue.add(2);
        doubleStackQueue.add(3);
        doubleStackQueue.add(3);
        doubleStackQueue.clear();

        assertEquals(0, doubleStackQueue.size());
    }

    @Test
    void clearWithRemove() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(1);
        doubleStackQueue.add(2);
        doubleStackQueue.remove();
        doubleStackQueue.add(3);
        doubleStackQueue.clear();

        assertEquals(0, doubleStackQueue.size());
    }

    @Test
    void clearWithoutAdding() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.clear();

        assertEquals(0, doubleStackQueue.size());
    }


}