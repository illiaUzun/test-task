package Task1;

import Task1.MergeArrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeArraysTest {

    @Test
    void merge() {
        int[] a1 = new int[]{1, 3, 6, 8, 9};
        int[] a2 = new int[]{1, 2, 4, 5};
        int[] r = MergeArrays.merge(a1, a2);
        int[] expected = new int[]{1, 1, 2, 3, 4, 5, 6, 8, 9};

        assertArrayEquals(expected, r);

        a1 = new int[]{1, 5, 2, 5, 6, 3, 66, 78, 34, 5, 34, 23};
        a2 = new int[]{52, 23, 42, 1, 4, 6, 5, 4, 3, 2, 5, 63};
        r = MergeArrays.merge(a1, a2);
        expected = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 23, 23, 34, 34, 42, 52, 63, 66, 78};

        assertArrayEquals(expected, r);
    }
}