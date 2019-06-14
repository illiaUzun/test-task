package Task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeArraysTest {

    @Test
    void mergeFirstMethod() {
        int[] a1 = new int[]{1, 3, 6, 8, 9};
        int[] a2 = new int[]{1, 2, 4, 5};
        int[] r = MergeArrays.mergeWithSort(a1, a2);
        int[] expected = new int[]{1, 1, 2, 3, 4, 5, 6, 8, 9};

        assertArrayEquals(expected, r);
    }

    @Test
    void mergeFirstMethod2() {
        int[] a1 = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 7, 8};
        int[] a2 = new int[]{2, 4, 6, 9, 10, 15, 20};
        int[] r = MergeArrays.mergeWithSort(a1, a2);
        int[] expected = new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10, 15, 20};

        assertArrayEquals(expected, r);
    }

    @Test
    void mergeFirstMethodWithEmptyArray() {
        int[] a1 = new int[]{};
        int[] a2 = new int[]{2, 4, 6, 9, 10, 15, 20};
        int[] r = MergeArrays.mergeWithSort(a1, a2);
        int[] expected = new int[]{2, 4, 6, 9, 10, 15, 20};

        assertArrayEquals(expected, r);
    }

    @Test
    void mergeFirstMethodWithSecondEmptyArray() {
        int[] a1 = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 7, 8};
        int[] a2 = new int[]{};
        int[] r = MergeArrays.mergeWithSort(a1, a2);
        int[] expected = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 7, 8};

        assertArrayEquals(expected, r);
    }

    @Test
    void mergeSecondMethod() {
        int[] a1 = new int[]{1, 3, 6, 8, 9};
        int[] a2 = new int[]{1, 2, 4, 5};
        int[] r = MergeArrays.merge(a1, a2);
        int[] expected = new int[]{1, 1, 2, 3, 4, 5, 6, 8, 9};

        assertArrayEquals(expected, r);
    }

    @Test
    void mergeSecondMethod2() {
        int[] a1 = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 7, 8};
        int[] a2 = new int[]{2, 4, 6, 9, 10, 15, 20};
        int[] r = MergeArrays.merge(a1, a2);
        int[] expected = new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10, 15, 20};

        assertArrayEquals(expected, r);
    }

    @Test
    void mergeSecondMethodWithEmptyArray() {
        int[] a1 = new int[]{};
        int[] a2 = new int[]{2, 4, 6, 9, 10, 15, 20};
        int[] r = MergeArrays.merge(a1, a2);
        int[] expected = new int[]{2, 4, 6, 9, 10, 15, 20};

        assertArrayEquals(expected, r);
    }

    @Test
    void mergeSecondMethodWithSecondEmptyArray() {
        int[] a1 = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 7, 8};
        int[] a2 = new int[]{};
        int[] r = MergeArrays.merge(a1, a2);
        int[] expected = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 7, 8};

        assertArrayEquals(expected, r);
    }
}