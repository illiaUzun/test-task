package Task1;

import com.google.common.base.Stopwatch;

import java.lang.reflect.Array;
import java.util.Arrays;


public class MergeArrays {
    public static void main(String[] args) {
    }

    /**
     * More complex (C style) mergeWithSort method without use of
     * additional utils
     * + more effective (performes faster)
     * <p>
     * At each iteration, we get the smaller of the first
     * two elements of two sub-arrays and put it into the
     * resulting array increasing the iterators of resulting
     * array and subarray, from which the element was taken by 1.
     * <p>
     * At the beginning of each iteration we check if one of arrays
     * is not empty and if it is then we add the remaining
     * elements of the second subarray to the resulting array.
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return merged and sorted array
     */
    public static int[] merge(int[] a1, int[] a2) {
        int[] r = new int[a1.length + a2.length];

        // i - iterator for result array; j - for first sub-array; k - for second
        for (int i = 0, j = 0, k = 0; i < r.length; i++) {
            if (j == a1.length) {
                System.arraycopy(a2, k, r, i, a2.length - k);
                break;
            }
            if (k == a2.length) {
                System.arraycopy(a1, j, r, i, a1.length - j);
                break;
            }
            if (a1[j] <= a2[k]){
                r[i] = a1[j];
                j++;
            } else if (a2[k] <= a1[j]) {
                r[i] = a2[k];
                k++;
            }
        }
        return r;
    }

    /**
     * OOP style mergeWithSort method:
     * + good readability
     * <p>
     * Algorithm:
     * 1) Copy first array to result array
     * 2) Copy second array to the end of result array
     * 3) Sort result array
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return merged and sorted array
     */
    public static int[] mergeWithSort(int[] a1, int[] a2) {
        long startTime = System.nanoTime();

        int[] r = (int[]) Array.newInstance(a1.getClass().getComponentType(), a1.length + a2.length);
        System.arraycopy(a1, 0, r, 0, a1.length);
        System.arraycopy(a2, 0, r, a1.length, a2.length);
        Arrays.sort(r);
        return r;
    }
}
