package package4;
public class Quick {
    //För att sotera listan
    public static void sortQ(int[] a) {
        sortQ(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sortQ(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        show(a);
        System.out.println();
        int j = partition(a, lo, hi);
        sortQ(a, lo, j-1);
        sortQ(a, j+1, hi);
    }

    // Jämföra mellan lo och hi element
    private static int partition(int[] a, int lo, int hi) {
        int i = lo; //pivot
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            // check if pointers cross
            if (i >= j) break;
            exch(a, i, j);
        }
        // put partitioning item v at a[j] Den första läsning
        exch(a, lo, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/
    // is v < w ?
    private static boolean less(int v, int w) {
        if (v == w) return false;   // optimization when reference equals
        return v-w < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = (int) swap;
    }
    /***************************************************************************
     *  Check if array is sorted
     ***************************************************************************/
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+ " " );
        }
    }
}