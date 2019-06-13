package Task1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeArrays {
    //Merging of 2 sorted arrays

    public static void main(String[] args) {
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] r = (int[]) Array.newInstance(a1.getClass().getComponentType(), a1.length + a2.length);
        System.arraycopy(a1, 0, r, 0, a1.length);
        System.arraycopy(a2, 0, r, a1.length, a2.length);
        Arrays.sort(r);
        return r;
    }
}
