package Task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoubleStackQueueTest {

    @Test
    void add() {
        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.add(1);
        doubleStackQueue.add(2);
        doubleStackQueue.add(3);

        assertEquals(3, doubleStackQueue.remove());
        assertEquals(2, doubleStackQueue.remove());
        assertEquals(1, doubleStackQueue.remove());
    }

    @Test
    void remove() {
    }

    @Test
    void peek() {
    }

    @Test
    void poll() {
    }
}